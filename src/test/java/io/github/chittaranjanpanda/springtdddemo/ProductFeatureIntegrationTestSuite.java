package io.github.chittaranjanpanda.springtdddemo;

import io.github.chittaranjanpanda.springtdddemo.product.ProductControllerIntegrationTest;
import io.github.chittaranjanpanda.springtdddemo.product.ProductRepositoryIntegrationTest;
import io.github.chittaranjanpanda.springtdddemo.product.ProductServiceIntegrationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductServiceIntegrationTest.class, ProductControllerIntegrationTest.class,
        ProductRepositoryIntegrationTest.class})
public class ProductFeatureIntegrationTestSuite {
}
