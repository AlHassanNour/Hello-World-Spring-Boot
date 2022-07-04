package de.htwberlin.webtech.web.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ContactManipulationRequest {
    @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
    private String firstName;
    @NotBlank(message = "The last name must not be empty.")
    private String secondName;
    private String work;
    @Email(message = "The E-mail must be valid.")
    private String email;
    private String phone;
    @Pattern( regexp = "MALE|FEMALE|DIVERSE|UNKOWN",
            message = "Please provide 'MALE', 'FEMALE', 'DIVERSE' or 'UNKNOWN' for gender"
    )
    private String gender;

    public ContactManipulationRequest(String firstName, String secondName, String work, String email, String phone, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.gender= gender;
    }

    public ContactManipulationRequest(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
