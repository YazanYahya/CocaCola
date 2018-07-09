package edu.birzeit.cocacola.application.service;


import edu.birzeit.cocacola.application.model.Phone;
import edu.birzeit.cocacola.application.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {


    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {

        List<Phone> phones = new ArrayList<>();

        phoneRepository.findAll().forEach(phones::add);
        return phones;
    }


    public Phone addPhone(Phone phone) {

        return phoneRepository.save(phone);
    }

    public Phone updatePhoneNumber(int id, Phone updatedPhone){
        Phone phone = this.phoneRepository.findById(id).orElse(null);
        if(phone == null)
            return null;
        phone.setNumber(updatedPhone.getNumber());
        return this.phoneRepository.save(phone);
    }
    public Phone deletePhone(int id){
        Phone phone = this.phoneRepository.findById(id).orElse(null);
        if(phone == null)
            return null;
        this.phoneRepository.deleteById(id);
        return phone;
    }
}
