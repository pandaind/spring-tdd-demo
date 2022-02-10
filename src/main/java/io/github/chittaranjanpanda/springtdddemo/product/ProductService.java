package io.github.chittaranjanpanda.springtdddemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductByNameStartsWith(String name) {
        return productRepository.findByNameStartsWith(name);
    }
}
