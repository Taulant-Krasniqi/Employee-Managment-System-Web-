package net.employee.employeeform.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Departament {
    private int departamentId;
    private String departamentName;

    @Id
    @Column(name = "DepartamentID", nullable = false)
    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    @Basic
    @Column(name = "Departament_Name", nullable = false, length = 255)
    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departament that = (Departament) o;
        return departamentId == that.departamentId &&
                Objects.equals(departamentName, that.departamentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamentId, departamentName);
    }
}
