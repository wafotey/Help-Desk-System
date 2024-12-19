package com.miu.edu.domain.aggregates.customerAggregate;

import com.miu.edu.domain.shared.ValueObject;

import java.util.Objects;

public class Address extends ValueObject {

    // Getters for the fields (if needed)
    private final String country;
    private final String city;
    private final String state;
    private final String zip;
    private final String street;

    protected Address() {
        this.country = null;
        this.city = null;
        this.state = null;
        this.zip = null;
        this.street = null;
    }

    // Constructor to initialize fields
    public Address(String country, String city, String state, String zip, String street) {
        this.country = country;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
    }


    // Implement the core equality check comparing all fields
    @Override
    protected boolean equalsCore(ValueObject other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Address otherAddress = (Address) other;
        return Objects.equals(this.country, otherAddress.country) &&
                Objects.equals(this.city, otherAddress.city) &&
                Objects.equals(this.state, otherAddress.state) &&
                Objects.equals(this.zip, otherAddress.zip) &&
                Objects.equals(this.street, otherAddress.street);
    }



    // Implement the hashCode method based on fields
    @Override
    public int hashCode() {
        return Objects.hash(country, city, state, zip, street);
    }

    // Method to return string representation of the object's fields (used in toString)
    @Override
    protected String fieldValues() {
        return "country='" + country + "', city='" + city + "', state='" + state + "', zip='" + zip + "', street='" + street + "'";
    }

    // Override toString for a user-friendly representation of the object
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + fieldValues() + "}";
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }
}
