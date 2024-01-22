package com.oriedroc.systems.order.service.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {
    private final UUID id;
    private final String street;

    private final String zipCode;
    private final String city;
    private final String number;

    public StreetAddress(UUID id, String street, String zipCode, String city, String number) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetAddress that = (StreetAddress) o;
        return Objects.equals(street, that.street) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, zipCode, city, number);
    }
}
