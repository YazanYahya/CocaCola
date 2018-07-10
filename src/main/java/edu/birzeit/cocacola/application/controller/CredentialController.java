package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.dto.CredentialResponse;
import edu.birzeit.cocacola.application.model.Credential;
import edu.birzeit.cocacola.application.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coca-cola/users")
public class CredentialController {

    @Autowired
    private CredentialService credentialService;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public ResponseEntity<CredentialResponse> authenticate(@RequestBody Credential credential) {
        CredentialResponse credentialResponse = credentialService.validate(credential);
        return new ResponseEntity(credentialResponse, HttpStatus.OK);
    }
}
