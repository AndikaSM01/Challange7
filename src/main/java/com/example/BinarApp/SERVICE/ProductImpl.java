package com.example.BinarApp.SERVICE;

import com.example.BinarApp.ENTITY.Merchant;
import com.example.BinarApp.ENTITY.Product;
import com.example.BinarApp.MODEL.RESPONSE.ProductResponse;
import com.example.BinarApp.REPOSITORY.MerchantRepository;
import com.example.BinarApp.REPOSITORY.ProdukRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProdukRepository produkRepository;
    @Autowired
    private MerchantRepository merchantRepository;
    @Override
    public String addProduct(String inputProductName, String inputPrice , String merchantCode) {
            Optional<Merchant> merchant = merchantRepository.findByMerchantCode(merchantCode);
            Merchant merchant1 = merchant.get();
            Product productNew = new Product();
        UUID uuid = UUID.randomUUID();
        String kode = uuid.toString().substring(0, 5);
            productNew.setProductCode(kode);
            productNew.setProductName(inputProductName);
            productNew.setPrice(Double.valueOf(inputPrice));
            productNew.setMerchant(merchant1);


            if (ProdukRepository.existsByProductName(inputProductName) || ProdukRepository.existsByPrice(inputPrice)) {
                log.warn("Menjalankan service addProduct");
                return "Produk dengan nama atau harga yang sama sudah ada";
            } else {

                produkRepository.save(productNew);
                log.info("Add Product: {}", productNew);
                return "Data Telah tersimpan";
            }
        }
    private List<ProductResponse> getProdukResponse(Product product, Merchant merchants) {
        List<ProductResponse> productResponses = new ArrayList<>();

        ProductResponse productResponse = ProductResponse.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .merchantName(merchants!= null ? merchants.getMerchantName() : null)
                .build();

        productResponses.add(productResponse);

        return productResponses;
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> ProductByID = produkRepository.findById(product.getId());
        if (ProductByID.isPresent()) {
            Product product1= ProductByID.get();
            product1.setProductCode(product.getProductCode() != null ? product.getProductCode() : product1.getProductCode());
            product1.setProductName(product.getProductName() != null ? product.getProductName() : product1.getProductName());
            product1.setPrice(product.getPrice() != null ? product.getPrice() : product1.getPrice());
            produkRepository.save(product1);
            log.info("Produk berhasil diupdate");
            return product1;
        } else {
            log.error("Produk tidak ditemukan");
            return  null;
        }
    }

    @Override
    public void delleteProduct(String product) {
        if (produkRepository.existsById(product)){
            produkRepository.deleteById(product);
            log.info("produk Berhasil dihapus {}", product);

        }else{
            log.error("Produk tidak ditemukan");

        }

    }
    @Override
    public Page<Product> getProductPaged(int page) {
        return produkRepository.findAll(PageRequest.of(page, 10));
    }

}
