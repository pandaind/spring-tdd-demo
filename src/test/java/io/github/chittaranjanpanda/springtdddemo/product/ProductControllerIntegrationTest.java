package io.github.chittaranjanpanda.springtdddemo.product;


import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

    @Autowired
    private ProductController productController;

    @Test
    public void testAddProduct(){
        Product product = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        ResponseEntity<Product> productResponseEntity = productController.addProduct(product);

        assertThat(productResponseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }


}
