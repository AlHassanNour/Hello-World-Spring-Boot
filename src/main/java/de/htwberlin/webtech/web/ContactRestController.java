package de.htwberlin.webtech.web;

import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.service.ContactService;
import de.htwberlin.webtech.web.api.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactRestController {

    private final ContactService contactService;

   public ContactRestController(ContactService contactService){
       this.contactService= contactService;
    }

    @GetMapping(path = "/api/v1/contacts")

    public ResponseEntity<List<Contact>> fetchContact(){

       return ResponseEntity.ok(contactService.findAll());
    }



}
