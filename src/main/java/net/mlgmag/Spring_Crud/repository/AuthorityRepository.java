package net.mlgmag.Spring_Crud.repository;

import net.mlgmag.Spring_Crud.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {

    Authority findByName(String name);

}
