package net.employee.employeeform.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Leavedata {
    private int leaveId;
    private int daysLeft;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "LeaveID", nullable = false)
    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    @Basic
    @Column(name = "Days_Left", nullable = false)
    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leavedata leavedata = (Leavedata) o;
        return leaveId == leavedata.leaveId &&
                daysLeft == leavedata.daysLeft;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaveId, daysLeft);
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
