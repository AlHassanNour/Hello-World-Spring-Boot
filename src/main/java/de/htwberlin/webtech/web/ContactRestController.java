package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.ContactService;
import de.htwberlin.webtech.web.api.Contact;
import de.htwberlin.webtech.web.api.ContactManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path = "/api/v1/contacts/{id}")

    public ResponseEntity<Contact> fetchContactById(@PathVariable int id){

       var contact= contactService.findById(id);
       return contact != null? ResponseEntity.ok(contact): ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/contacts")

    public ResponseEntity<Void> ctreateContact(@RequestBody ContactManipulationRequest request) throws URISyntaxException {
       var contact= contactService.create(request);
       URI uri = new URI ("/api/v1/contacts" + contact.getId());
       return ResponseEntity.created(uri).build();
    }

   @PutMapping(path = "/api/v1/contacts/{id}")

    public ResponseEntity<Contact> updateContact(@PathVariable int id,@RequestBody ContactManipulationRequest request ){

       var contact = contactService.update(id, request);
       return contact != null? ResponseEntity.ok(contact): ResponseEntity.notFound().build();
   }

    @DeleteMapping(path = "/api/v1/contacts/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        boolean successful = contactService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
