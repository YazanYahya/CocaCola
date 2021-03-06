package edu.birzeit.cocacola.application.controller;


import edu.birzeit.cocacola.application.model.Phone;
import edu.birzeit.cocacola.application.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coca-cola/phones")
public class PhoneController {


    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/{userid}")
    public ResponseEntity<List<Phone>> getAllPhonesForUser(@PathVariable int userid) {

        List<Phone> phones = phoneService.getAllPhonesForUser(userid);
        if (phones == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(phones, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/{userid}")
    public ResponseEntity<Phone> addPhoneForUser(@RequestBody Phone phone, @PathVariable int userid) {
        Phone p = phoneService.addPhoneForUser(phone, userid);
        if (p == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(p, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Phone> updatePhoneNumber(@PathVariable("id") int id, @RequestBody Phone phone) {
        Phone updatedPhone = this.phoneService.updatePhoneNumber(id, phone);
        if (updatedPhone == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable("id") int id) {
        Phone deletedPhone = this.phoneService.deletePhone(id);
        if (deletedPhone == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(deletedPhone, HttpStatus.OK);
    }


}
