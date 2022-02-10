package io.github.chittaranjanpanda.springtdddemo;

import io.github.chittaranjanpanda.springtdddemo.product.ProductControllerIntegrationTest;
import io.github.chittaranjanpanda.springtdddemo.system.DataStoreSystemHealthTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DataStoreSystemHealthTest.class,
        ProductControllerIntegrationTest.class
})
public class ContinuosIntegrationTestSuite {
}
