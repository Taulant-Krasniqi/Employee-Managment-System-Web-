package net.employee.employeeform.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String phone;
    private String gender;
    private String bankName;
    private String bankDetails;
    private Address addressByAddressId;

    private Position positionByPositionId;
    private Departament departamentByDepartamentId;


    @Id
    @Column(name = "EmployeeID", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "First_Name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Last_Name", nullable = false, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Gender", nullable = false, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Bank_Name", nullable = false, length = 255)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "Bank_Details", nullable = false, length = 255)
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
                Objects.equals(bankName, employee.bankName) &&
                Objects.equals(bankDetails, employee.bankDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, email, birthday, phone, gender, bankName, bankDetails);
    }

    @ManyToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }



    @ManyToOne
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID", nullable = false)
    public Position getPositionByPositionId() {
        return positionByPositionId;
    }

    public void setPositionByPositionId(Position positionByPositionId) {
        this.positionByPositionId = positionByPositionId;
    }

    @ManyToOne
    @JoinColumn(name = "DepartamentID", referencedColumnName = "DepartamentID", nullable = false)
    public Departament getDepartamentByDepartamentId() {
        return departamentByDepartamentId;
    }

    public void setDepartamentByDepartamentId(Departament departamentByDepartamentId) {
        this.departamentByDepartamentId = departamentByDepartamentId;
    }

   
}
