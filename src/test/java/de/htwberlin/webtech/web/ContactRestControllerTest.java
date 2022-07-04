package de.htwberlin.webtech.web;
import org.springframework.test.web.servlet.MockMvc;
import de.htwberlin.webtech.service.ContactService;
import de.htwberlin.webtech.web.api.Contact;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collections;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.ArgumentMatchers.any;


@WebMvcTest(ContactRestController.class)
public class ContactRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

  /*  @Test
    @DisplayName("should return found persons from contact service")
    void should_return_found_contcat_from_contact_service() throws Exception{
        // given
        var contacts= List.of(
                new Contact(1, "Nour", "Al Hassan", "Student", "018739394", "nour@gmail.com", "FEMALE",Collections.emptyList()),
                new Contact(2, "Max", "Mustermann", "Student", "23213123", "max@gmail.com", "Male",Collections.emptyList())
        );
        doReturn(contacts).when(contactService).findAll();
        // when
        mockMvc.perform(get("/api/v1/contacts"))
        // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("Nour"))
                .andExpect(jsonPath("$[0].secondName").value("Al Hassan"))
                .andExpect(jsonPath("$[0].work").value("Student"))
                .andExpect(jsonPath("$[0].phone").value("018739394"))
                .andExpect(jsonPath("$[0].email").value("nour@gmail.com"))
                .andExpect(jsonPath("$[0].gender").value("FEMALE"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Max"))
                .andExpect(jsonPath("$[1].secondName").value("Mustermann"))
                .andExpect(jsonPath("$[1].work").value("Student"))
                .andExpect(jsonPath("$[1].phone").value("23213123"))
                .andExpect(jsonPath("$[1].email").value("max@gmail.com"))
                .andExpect(jsonPath("$[1].gender").value("MALE"));
    }*/
    @Test
    @DisplayName("should return 404 if contact is not found")
    void should_return_404_if_contact_is_not_found() throws Exception {
        // given
        doReturn(null).when(contactService).findById(anyInt());
        // when
        mockMvc.perform(get("/api/v1/contacts/123"))
                // then
                .andExpect(status().isNotFound());
    }
    /*@Test
    @DisplayName("should return 201 http status and Location header when creating a contact")
    void should_return_201_http_status_and_location_header_when_creating_a_contact() throws Exception {
        // given
        String contactToCreateAsJson = "{\"firstName\": \"Nour\", \"lastName\":\"Al Hassan\", \"gender\":\"FEMALE\", \"work\": \"Student\", \"phone\": \"018739394\", \"email\":\"nour22@gmail.com\"}";
        var contact = new Contact(123, null, null, null, null, null,null);
        doReturn(contact).when(contactService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/contacts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(contactToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/contacts/" + contact.getId()))));
//            .andExpect(header().string("Location", Matchers.containsString(Long.toString(person.getId()))));

    }*/
    @Test
    @DisplayName("should validate create contact request")
    void should_validate_create_contact_request() throws Exception {
        // given
        String contactToCreateAsJson = "{\"firstName\": \"a\", \"lastName\":\"\", \"gender\":\"FEMALE\", \"work\": \"Student\", \"phone\": \"018739394\", \"email\":\"nour@gmail.com\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/contacts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(contactToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
