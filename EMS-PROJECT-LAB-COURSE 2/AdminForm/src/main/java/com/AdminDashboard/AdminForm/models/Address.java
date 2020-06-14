package com.AdminDashboard.AdminForm.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


public class Address {
    private int addressId;
    private String streetName;
    private String streetNumber;
    private String zipCode;
    private String state;
    private String town;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(streetNumber, address.streetNumber) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(state, address.state) &&
                Objects.equals(town, address.town);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, streetName, streetNumber, zipCode, state, town);
    }
}
