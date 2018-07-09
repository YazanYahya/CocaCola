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

    @RequestMapping(value = "/")
    public ResponseEntity<List<Phone>> getAllPhones() {

        List<Phone> phones = phoneService.getAllPhones();
        return new ResponseEntity<>(phones, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Phone> addPhone(@RequestBody Phone phone) {
        Phone p = phoneService.addPhone(phone);
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
