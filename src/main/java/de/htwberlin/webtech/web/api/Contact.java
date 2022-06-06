package de.htwberlin.webtech.web.api;

public class Contact {

    private int id;
    private String firstName;
    private String secondName;
    private String work;
    private String email;
    private String phone;


    public Contact(int id, String firstName, String secondName, String work, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.work = work;
        this.email = email;
        this.phone = phone;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
