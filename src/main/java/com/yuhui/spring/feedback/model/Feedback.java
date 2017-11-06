package com.yuhui.spring.feedback.model;

import javax.persistence.*;

@Entity
public class Feedback {

    @Id
//    @GeneratedValue(strategy = GenerationType.)
    // when id is auto generated, type cannot be String.
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNum;
    private String city;
    private String country;
    private String postalCode;
    private String rating;
    private String comment;

//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;

    public Feedback() {}

    public Feedback(String id) {
        this.id = id;
    }

    public Feedback(String firstName, String lastName, String address, String phoneNum, String city, String country, String postalCode, String rating, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.rating = rating;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
