package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.web.api.Contact;
import de.htwberlin.webtech.web.api.ContactCreateRequest;
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

    public Contact create(ContactCreateRequest request){

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
}
