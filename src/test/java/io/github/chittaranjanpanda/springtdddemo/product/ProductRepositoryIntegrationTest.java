package io.github.chittaranjanpanda.springtdddemo.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetFindByNameStartsWith(){
        Product product = Product.builder()
                .name("Mi note 5 Pro")
                .price(15000.00)
                .quantity(1)
                .uom("each").build();

        entityManager.persist(product);

        List<Product> newProducts = productRepository.findByNameStartsWith("Mi");

        assertNotNull(newProducts);
        assertTrue(newProducts.get(0).getName().startsWith("Mi"));
    }
}
