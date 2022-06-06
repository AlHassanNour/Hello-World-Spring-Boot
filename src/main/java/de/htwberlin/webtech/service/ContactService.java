package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.web.api.Contact;
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
        return contacts.stream().map(contactEntity -> new Contact(
                contactEntity.getId(),
                contactEntity.getFirstName(),
                contactEntity.getSecondName(),
                contactEntity.getWork(),
                contactEntity.getEmail(),
                contactEntity.getPhone()
        ))
                .collect(Collectors.toList());
    }
}
