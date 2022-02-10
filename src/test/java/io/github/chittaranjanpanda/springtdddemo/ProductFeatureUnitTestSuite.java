package io.github.chittaranjanpanda.springtdddemo;

import io.github.chittaranjanpanda.springtdddemo.product.ProductControllerUnitTest;
import io.github.chittaranjanpanda.springtdddemo.product.ProductRepositoryDBUnitTest;
import io.github.chittaranjanpanda.springtdddemo.product.ProductServiceUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProductServiceUnitTest.class, ProductControllerUnitTest.class,
        ProductRepositoryDBUnitTest.class})
public class ProductFeatureUnitTestSuite {
}
