package io.github.chittaranjanpanda.springtdddemo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final String BY_ID = "/{id}";
    private final String BY_NAME = "/?name={name}";

    private final ProductService productService;

    @Autowired
    ProductController(final ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(BY_ID)
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping(BY_NAME)
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Product> addProduct(Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
}
