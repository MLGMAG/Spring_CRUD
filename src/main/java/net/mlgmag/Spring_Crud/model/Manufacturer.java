package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
@Data
@EqualsAndHashCode(exclude = "products")
//Added 2 annotations (@EqualsAndHashCode and @ToString), because throws StackOverflow exception
@ToString(exclude = "products")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Name can't be empty")
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "manufacturer")
    private Set<Product> products;

}
