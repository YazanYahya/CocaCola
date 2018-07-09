package edu.birzeit.cocacola.application.controller;


import edu.birzeit.cocacola.application.model.Phone;
import edu.birzeit.cocacola.application.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}
