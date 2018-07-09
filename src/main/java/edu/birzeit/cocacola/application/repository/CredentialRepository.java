package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.Credential;
import edu.birzeit.cocacola.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {
    User findByUsername(String username);

    User findByPassword(String password);

}
