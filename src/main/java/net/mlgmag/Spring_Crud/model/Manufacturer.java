package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "manufacturers")
@EqualsAndHashCode(exclude = "products")
//Added 2 annotations (@EqualsAndHashCode and @ToString), because throws StackOverflow exception
@ToString(exclude = "products")
public class Manufacturer implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "manufacturer")
    private Set<Product> products;

}
