package com.yapss;
import java.util.Date;
/**
 * Created by Max on 10/10/16.
 * Basic class for the User object
 * TODO : investigate if java is stupid and
 * requires more logic to do this following stuff,
 * might be too pythonian?
 * I do have the solution if this would be the case
 * meask over and out, dinosaur!
 */


public class User {

    private Long id;

    private String firstName = "";

    private String lastName = "";

    private Date birthDate;

    private String email = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstNameName() {
        return lastName;
    }

    public void setFirstName(String lastName) {
        this.lastName = lastName;
    }



}