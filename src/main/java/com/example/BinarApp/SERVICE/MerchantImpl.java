package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Merchant;
import com.example.BinarApp.MODEL.ENUM.MerchantEnum;
import com.example.BinarApp.MODEL.REQUEST.MerchantRequest;
import com.example.BinarApp.MODEL.RESPONSE.MerchantResponse;
import com.example.BinarApp.REPOSITORY.MerchantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MerchantImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;


    @Override
    public MerchantResponse addMerchant(MerchantRequest merchant) {
        if (!merchantRepository.existsByMerchantName(merchant.getMerchantName())) {
            Merchant merchant1 = new Merchant();
            UUID uuid = UUID.randomUUID();
            String kode = uuid.toString().substring(0, 5);
            merchant1.setMerchantCode(kode);
            merchant1.setMerchantName(merchant.getMerchantName());
            merchant1.setMerchantLocation(merchant.getMerchantLocation());
            merchant1.setOpen(true);
            merchantRepository.save(merchant1);

           MerchantResponse merchantResponse = MerchantResponse.builder()
                           .MerchantCode(merchant1.getMerchantCode())
                           .MerchantName(merchant.getMerchantName())
                           .Location(merchant1.getMerchantLocation())
                           .open("Open").build();
            log.info("Merchant berhasil ditambahkan: {}", merchant.getMerchantName());
           return  merchantResponse;
        }else {
            log.error("Merchant sudah tersedia: {}", merchant.getMerchantName());
           return null;
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
        Optional<Merchant> merchantById = merchantRepository.findById(merchant.getMerchantCode());

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
            return null;
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
