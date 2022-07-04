package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.ContactEntity;
import de.htwberlin.webtech.persistence.Gender;
import de.htwberlin.webtech.web.api.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactTransformer {
    public Contact transformEntity(ContactEntity contactEntity) {
        var gender = contactEntity.getGender() != null ? contactEntity.getGender().name() : Gender.UNKNOWN.name();
        return new Contact(
                contactEntity.getId(),
                contactEntity.getFirstName(),
                contactEntity.getSecondName(),
                contactEntity.getWork(),
                contactEntity.getEmail(),
                contactEntity.getPhone(),
                gender
        );
    }
}
