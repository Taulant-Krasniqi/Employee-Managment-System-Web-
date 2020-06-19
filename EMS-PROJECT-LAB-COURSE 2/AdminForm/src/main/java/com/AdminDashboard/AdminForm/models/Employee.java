package com.AdminDashboard.AdminForm.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String phone;
    private String gender;
    private String streetName;
    private String town;
    private String zipCode;
    private String bankName;
    private String bankDetails;
    private Departament departamentByDepartamentId;
    private Position positionByPositionId;



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }


    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                Objects.equals(birthday, employee.birthday) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(streetName, employee.streetName) &&
                Objects.equals(town, employee.town) &&
                Objects.equals(zipCode, employee.zipCode) &&
                Objects.equals(bankName, employee.bankName) &&
                Objects.equals(bankDetails, employee.bankDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, birthday, phone, gender, streetName, town, zipCode, bankName, bankDetails);
    }

    public Departament getDepartamentByDepartamentId() {
        return departamentByDepartamentId;
    }

    public void setDepartamentByDepartamentId(Departament departamentByDepartamentId) {
        this.departamentByDepartamentId = departamentByDepartamentId;
    }


    public Position getPositionByPositionId() {
        return positionByPositionId;
    }

    public void setPositionByPositionId(Position positionByPositionId) {
        this.positionByPositionId = positionByPositionId;
    }



   
}
