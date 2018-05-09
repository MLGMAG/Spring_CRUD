package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Document(collection = "products")
public class Product implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private BigDecimal price;

    private Manufacturer manufacturer;

}
