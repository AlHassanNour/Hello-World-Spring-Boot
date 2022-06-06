package de.htwberlin.webtech.web;

import de.htwberlin.webtech.persistence.ContactRepository;
import de.htwberlin.webtech.service.ContactService;
import de.htwberlin.webtech.web.api.Contact;
import de.htwberlin.webtech.web.api.ContactCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/contacts")

    public ResponseEntity<Void> ctreateContact(@RequestBody ContactCreateRequest request) throws URISyntaxException {
       var contact= contactService.create(request);
       URI uri = new URI ("/api/v1/contacts" + contact.getId());
       return ResponseEntity.created(uri).build();
    }



}
