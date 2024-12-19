package com.miu.edu.domain.aggregates.customerAggregate;

import com.miu.edu.domain.shared.AggregateRoot;
import com.miu.edu.domain.shared.Entity;

public class Customer extends Entity implements AggregateRoot {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;
    protected Customer() {}
    public Customer(String firstName, String lastName, String email, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }
}