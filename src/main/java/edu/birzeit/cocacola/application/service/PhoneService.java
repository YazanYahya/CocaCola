package edu.birzeit.cocacola.application.service;


import edu.birzeit.cocacola.application.model.Phone;
import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.repository.PhoneRepository;
import edu.birzeit.cocacola.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService {


    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Phone> getAllPhonesForUser(int user_id) {
        if (userRepository.findById(user_id) == null)
            return null;
        else
            return this.phoneRepository.findByUser_id(user_id);
    }


    public Phone addPhoneForUser(Phone phone, int userid) {
        User user = userRepository.findById(userid);

        if (user == null)
            return null;
        else {
            phone.setUser(user);
            return phoneRepository.save(phone);
        }
    }

    public Phone updatePhoneNumber(int id, Phone updatedPhone) {
        Phone phone = this.phoneRepository.findById(id).orElse(null);
        if (phone == null)
            return null;
        phone.setNumber(updatedPhone.getNumber());
        return this.phoneRepository.save(phone);
    }

    public Phone deletePhone(int id) {
        Phone phone = this.phoneRepository.findById(id).orElse(null);
        if (phone == null)
            return null;
        this.phoneRepository.deleteById(id);
        return phone;
    }
}
