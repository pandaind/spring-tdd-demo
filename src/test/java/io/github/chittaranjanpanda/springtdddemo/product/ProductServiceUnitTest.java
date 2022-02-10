package io.github.chittaranjanpanda.springtdddemo.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith ( MockitoJUnitRunner.class )
@SpringBootTest ( webEnvironment = SpringBootTest.WebEnvironment.NONE )
public class ProductServiceUnitTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this.getClass());
    }

    @Test
    public void testAddProduct() {
        Product mockProduct = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        when(productRepository.save(any(Product.class))).thenReturn(Optional.of(mockProduct).get());

        Product product = productService.addProduct(mockProduct);

        assertNotNull(product);
        assertEquals(product.getName(),mockProduct.getName());
    }

}
