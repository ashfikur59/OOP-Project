//package org.redoy;

public class Address {
    String street;
    String city;
    String country;
    Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }
    public String displayAddress() {
        return this.street + " " + this.city + " " + this.country;
    }
}
