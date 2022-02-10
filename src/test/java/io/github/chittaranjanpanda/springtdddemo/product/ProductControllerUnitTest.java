package io.github.chittaranjanpanda.springtdddemo.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this.getClass());
    }

    @Test
    public void testAddProduct() throws Exception {
        Product mockProduct = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        when(productService.addProduct(any(Product.class))).thenReturn(mockProduct);

        Product product = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        mockMvc.perform(post("/product", product).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();
    }
}
