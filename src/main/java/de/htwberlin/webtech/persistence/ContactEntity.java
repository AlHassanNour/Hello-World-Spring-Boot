package de.htwberlin.webtech.persistence;


import javax.persistence.*;

@Entity(name = "contacts")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "work")
    private String work;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;


    public ContactEntity(int id, String firstName, String secondName, String work, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.work = work;
        this.email = email;
        this.phone = phone;

    }

    protected ContactEntity() {

    }

    public int getId() {
        return id;
    }



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

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
