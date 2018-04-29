package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Document(collection = "products")
public class Product implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "Name can't be empty")
    private String name;

    @PositiveOrZero(message = "Value must be 0 or positive")
    private BigDecimal price;

    private Manufacturer manufacturer;

}
