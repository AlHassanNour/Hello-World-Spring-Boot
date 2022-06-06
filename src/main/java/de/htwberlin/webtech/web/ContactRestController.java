package de.htwberlin.webtech.web;

import de.htwberlin.webtech.web.api.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContactRestController {

    private List<Contact> contacts;

    public ContactRestController(){

        contacts = new ArrayList<>();
        contacts .add(new Contact(1, "Max", "Mustermann", "student", "test@gmail.com", "018278739"));
        contacts . add(new Contact(2, "Philip", "Müller", "student", "test1@gmail.com", "07862738"));
    }

    @GetMapping(path = "/api/v1/contacts")

    public ResponseEntity<List<Contact>> fetchContact(){
        return ResponseEntity.ok(contacts);
    }



}
