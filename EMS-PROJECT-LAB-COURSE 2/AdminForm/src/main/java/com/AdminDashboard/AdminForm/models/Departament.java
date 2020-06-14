package com.AdminDashboard.AdminForm.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


public class Departament {
    private int departamentId;
    private String departamentName;


    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }


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
