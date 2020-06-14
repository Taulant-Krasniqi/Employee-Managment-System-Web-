package net.employee.employeeform.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "request_leave", schema = "employee_data", catalog = "")
public class RequestLeave {
    private int requestId;
    private String description;
    private Date leaveDate;
    private Date returnDate;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "RequestID", nullable = false)
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "Description", nullable = false, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Leave_Date", nullable = false)
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Basic
    @Column(name = "Return_Date", nullable = false)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLeave that = (RequestLeave) o;
        return requestId == that.requestId &&
                Objects.equals(description, that.description) &&
                Objects.equals(leaveDate, that.leaveDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, description, leaveDate, returnDate);
    }

    @ManyToOne
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
