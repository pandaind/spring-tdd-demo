package io.github.chittaranjanpanda.springtdddemo.system;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataStoreSystemHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbPrimaryIsOk() {
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertThat(metaData, is(notNullValue()));
            assertThat(catalogName, is(equalTo("TESTDB")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
