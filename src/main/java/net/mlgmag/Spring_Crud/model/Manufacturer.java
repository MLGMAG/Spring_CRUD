package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

@Data
@Document(collection = "manufacturers")
@EqualsAndHashCode(exclude = "products")
//Added 2 annotations (@EqualsAndHashCode and @ToString), because throws StackOverflow exception
@ToString(exclude = "products")
public class Manufacturer implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private Set<Product> products;

}
