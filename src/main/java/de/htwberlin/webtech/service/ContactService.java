package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.web.api.Contact;
import de.htwberlin.webtech.web.api.ContactManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository){
        this.contactRepository=contactRepository;
    }

    public List<Contact> findAll(){

        List<ContactEntity> contacts = contactRepository.findAll();
        return contacts.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Contact create(ContactManipulationRequest request){

        var contactEntity= new ContactEntity(request.getFirstName(),request.getSecondName(),request.getWork(),request.getEmail(),request.getPhone());
      contactEntity =   contactRepository.save(contactEntity);
      return transformEntity(contactEntity);
    }

    private Contact transformEntity(ContactEntity contactEntity){
        return new Contact(
                contactEntity.getId(),
                contactEntity.getFirstName(),
                contactEntity.getSecondName(),
                contactEntity.getWork(),
                contactEntity.getEmail(),
                contactEntity.getPhone()
        );
    }

    public Contact findById(int id) {
        var contactEntity= contactRepository.findById(id);
        return contactEntity.isPresent()? transformEntity(contactEntity.get()) : null;
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
        contactEntity=contactRepository.save(contactEntity);
        return transformEntity(contactEntity);
    }

    public boolean deleteById(int id) {
        if (!contactRepository.existsById(id)) {
            return false;
        }
        contactRepository.deleteById(id);
        return true;
    }
}
