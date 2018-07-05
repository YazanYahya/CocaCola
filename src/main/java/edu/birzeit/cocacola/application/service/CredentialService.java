package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.model.Credential;
import edu.birzeit.cocacola.application.model.CredentialResponse;
import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialService {
    @Autowired
    private CredentialRepository credentialRepository;


    public User getUserByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }

    public User getUserByPassword(String password) {
        return credentialRepository.findByPassword(password);
    }

    public CredentialResponse validate(Credential credential) {
        String username=credential.getUsername();
        String pass=credential.getPassword();
        User user = getUserByUsername(username);
        CredentialResponse credentialResponse = new CredentialResponse();
        if (user == null) { //username error
            credentialResponse.setNote("Username is Wrong !");
            credentialResponse.setUser(null);
        } else { //usernmae is right
            User user1 = getUserByPassword(pass);
            if (user1 == null) { //password is wrong
                credentialResponse.setNote("Password is error !");
                credentialResponse.setUser(null);
            } else {
                credentialResponse.setUser(user1);
                credentialResponse.setNote(null);
            }
        }
        return credentialResponse;
    }
}
