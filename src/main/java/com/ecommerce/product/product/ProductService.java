package com.ecommerce.product.product;

import com.ecommerce.product.product.dto.ProductRequest;
import com.ecommerce.product.repository.product.ProductEntity;
import com.ecommerce.product.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity create(ProductRequest request) {
        return productRepository.save(ProductEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build());
    }

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public ProductEntity getById(Integer id) throws Exception {
        Optional<ProductEntity> optProduct = productRepository.findById(id);

        if (optProduct.isEmpty()) {
            throw new Exception("Data not found");
        }

        return optProduct.get();
    }

    public ProductEntity updateById(ProductRequest request, Integer id) throws Exception {
        ProductEntity product = this.getById(id);

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        productRepository.save(product);

        return product;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
