package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.persistence.Gender;
import de.htwberlin.webtech.web.api.Contact;
import de.htwberlin.webtech.web.api.ContactManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactTransformer contactTransformer;

    public ContactService(ContactRepository contactRepository, ContactTransformer contactTransformer){
        this.contactRepository=contactRepository;
        this.contactTransformer = contactTransformer;
    }

    public List<Contact> findAll(){

        List<ContactEntity> contacts = contactRepository.findAll();
        return contacts.stream().map(contactTransformer::transformEntity)
                .collect(Collectors.toList());
    }

    public Contact create(ContactManipulationRequest request){
       var gender = Gender.valueOf(request.getGender());
        var contactEntity= new ContactEntity(request.getFirstName(),request.getSecondName(),request.getWork(),request.getEmail(),request.getPhone(),gender);
      contactEntity =   contactRepository.save(contactEntity);
      return contactTransformer.transformEntity(contactEntity);
    }

    public Contact findById(int id) {
        var contactEntity= contactRepository.findById(id);
        return contactEntity.map(contactTransformer::transformEntity).orElse(null);
    }

    public Contact update(int id, ContactManipulationRequest request) {
        var contactEntityOptional = contactRepository.findById(id);
        if(contactEntityOptional.isEmpty()){
            return null;
        }

        var contactEntity = contactEntityOptional.get();
        contactEntity.setFirstName(request.getFirstName());
        contactEntity.setSecondName(request.getSecondName());
        contactEntity.setWork(request.getWork());
        contactEntity.setEmail(request.getEmail());
        contactEntity.setPhone(request.getPhone());
        contactEntity.setGender(Gender.valueOf(request.getGender()));
        contactEntity=contactRepository.save(contactEntity);

        return contactTransformer.transformEntity(contactEntity);
    }

    public boolean deleteById(int id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }
}
