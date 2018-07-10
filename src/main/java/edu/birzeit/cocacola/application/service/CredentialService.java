package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.dto.CredentialResponse;
import edu.birzeit.cocacola.application.model.Credential;
import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.repository.CredentialRepository;
import edu.birzeit.cocacola.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {

    @Autowired
    private CredentialRepository credentialRepository;

    public CredentialResponse validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();
        Credential userCredentialByUserName = this.credentialRepository.findByUsername(username);
        CredentialResponse credentialResponse = new CredentialResponse();
        if (userCredentialByUserName == null) { //username error
            credentialResponse.setNote("Username is Wrong !");
            credentialResponse.setUser(null);
            credentialResponse.setLoggedIn(false);
        } else { //usernmae is right
            Credential userCredentialByPassword = this.credentialRepository.findByPassword(password);
            if (userCredentialByPassword == null) { //password is wrong
                credentialResponse.setNote("Password is error !");
                credentialResponse.setUser(null);
                credentialResponse.setLoggedIn(false);
            } else {
                credentialResponse.setUser(userCredentialByPassword.getUser());
                credentialResponse.setNote(null);
                credentialResponse.setLoggedIn(true);

            }
        }
        return credentialResponse;
    }
}
