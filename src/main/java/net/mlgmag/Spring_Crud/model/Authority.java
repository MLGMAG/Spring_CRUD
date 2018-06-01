package net.mlgmag.Spring_Crud.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "authorities")
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uuid", unique = true)
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authorities")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return name;
    }

}
