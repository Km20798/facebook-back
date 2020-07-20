package com.karim.facebook.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String firstname ;

    private String surname ;

    private String email;

    private String password;

    private Date date;

    private String gender ;

    private int active ;

    private String role ;

    //Constructor
    public User(){

    }

    public User(String firstname, String surname, String email, String password, Date date, String gender) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.date = date;
        this.gender = gender;
        this.role = "ROLE_USER";
        this.active = 1 ;
    }

    //Setter And Getter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                ", active=" + active +
                ", role='" + role + '\'' +
                '}';
    }
}
