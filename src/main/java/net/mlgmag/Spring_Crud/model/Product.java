package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Column(name = "price", columnDefinition = "DECIMAL(16, 2)")
    @PositiveOrZero(message = "Value must be 0 or positive")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id", columnDefinition = "BINARY(16)")
    private Manufacturer manufacturer;

}
