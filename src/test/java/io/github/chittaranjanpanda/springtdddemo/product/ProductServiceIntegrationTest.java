package io.github.chittaranjanpanda.springtdddemo.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith ( SpringRunner.class )
@SpringBootTest ( webEnvironment = SpringBootTest.WebEnvironment.NONE )
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() {

        Product product = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        Product newProduct = productService.addProduct(product);

        assertNotNull(newProduct);
        assertNotNull(newProduct.getId());
        assertEquals("Mi note 5 Pro", newProduct.getName());
    }

    @Test
    public void testProductByNameLike() {
        Product product = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        productService.addProduct(product);

        List<Product> products = productService.getProductByNameStartsWith("Mi");

        assertNotNull(products);
        assertTrue(products.get(0).getName().startsWith("Mi"));

    }

}
