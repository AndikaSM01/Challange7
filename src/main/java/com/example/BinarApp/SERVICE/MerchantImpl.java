package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Merchant;
import com.example.BinarApp.MODEL.MerchantEnum;
import com.example.BinarApp.MODEL.RESPONSE.MerchantResponse;
import com.example.BinarApp.REPOSITORY.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MerchantImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;


    @Override
    public MerchantResponse addMerchant(Merchant merchant) {
        if (merchantRepository.existsByMerchantName(merchant.getMerchantName())) {
            merchantRepository.save(merchant);
            List<MerchantResponse> merchantResponses = getMerchantResponse(Collections.singletonList(merchant));
            log.info("Merchant berhasil ditambahkan: {}", merchant.getMerchantName());
            return merchantResponses.get(0);
        }else {
            log.error("Merchant sudah tersedia: {}", merchant.getMerchantName());
            return new MerchantResponse("Merchant is Exist ");
        }

    }

    private List<MerchantResponse>getMerchantResponse(List<Merchant> merchants){
        return merchants.stream()
                .map(merchant -> MerchantResponse.builder()
                        .MerchantName(merchant.getMerchantName())
                        .Location(merchant.getMerchantLocation())
                        .open(merchant.getOpen().toString())
                        .build()
                ).collect(Collectors.toList());
    }
    @Override
    public MerchantResponse updateMerchant(Merchant merchant) {
        log.debug("Merchant Service dijalankan");
        Optional<Merchant> merchantById = merchantRepository.findById(Long.valueOf(merchant.getMerchantCode()));

        if (merchantById.isPresent()) {
            Merchant oldMerchant = merchantById.get();
            oldMerchant.setOpen(merchant.getOpen() != null ? merchant.getOpen() : oldMerchant.getOpen());
            merchantRepository.save(oldMerchant);

            // Pastikan Anda memiliki implementasi yang sesuai untuk getMerchantResponse
            List<MerchantResponse> merchantResponses = getMerchantResponse(Collections.singletonList(oldMerchant));
            log.info("Merchant berhasil diedit: {}", oldMerchant.getMerchantName());

            return merchantResponses.get(0); // Mengembalikan hasil perubahan merchant
        } else {
            log.error("Merchant tidak ditemukan: {}", merchant.getMerchantName());
            // Anda dapat melempar pengecualian atau mengembalikan respons kesalahan yang sesuai
            return new MerchantResponse("Merchant tidak ditemukan");
        }
    }


    @Override
    public List<MerchantResponse> ShowMerchantStatusOPen() {
        log.debug("ShowMerchantStatusOpen dijalankan");
        List<Merchant> merchants = merchantRepository.findByMerchantEnum(MerchantEnum.OPEN);

        if (!merchants.isEmpty()) {
            log.info("Mendapatkan item merchant");
            // Pastikan Anda memiliki implementasi yang sesuai untuk getMerchantResponse
            return getMerchantResponse(merchants);
        } else {


            log.error("Merchant kosong");
            return Collections.emptyList(); // Mengembalikan daftar kosong jika tidak ada merchant terbuka
        }
    }

}
