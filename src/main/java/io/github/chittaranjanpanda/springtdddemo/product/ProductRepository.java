package io.github.chittaranjanpanda.springtdddemo.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findByNameStartsWith(@Param ("name") String name);
}
