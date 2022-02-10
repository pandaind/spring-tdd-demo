package io.github.chittaranjanpanda.springtdddemo.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity ( name = "PRODUCT" )
@NamedQueries ( {
        @NamedQuery ( name = "Product.findByNameStartsWith", query = "SELECT p from PRODUCT p where p.name like CONCAT(:name,'%')" )
} )
public class Product implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column(updatable = false, unique = true)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String uom;
}
