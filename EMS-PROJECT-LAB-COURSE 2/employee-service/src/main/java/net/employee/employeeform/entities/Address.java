package net.employee.employeeform.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Address {
    private int addressId;
    private String streetName;
    private String streetNumber;
    private String zipCode;
    private String state;
    private String town;

    @Id
    @Column(name = "AddressID", nullable = false)
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "Street_Name", nullable = false, length = 255)
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "Street_Number", nullable = false, length = 255)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "Zip_Code", nullable = false, length = 255)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "State", nullable = false, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Town", nullable = false, length = 255)
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
