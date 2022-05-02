package com.hotelreservationapp.model;

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;


    public Customer(String email, String firstName, String lastName) {
        isValidEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(.+).(.+)$");
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Error: Incorrect Email Format");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + " Last Name: " + lastName + " Email: " + email;
    }
}
