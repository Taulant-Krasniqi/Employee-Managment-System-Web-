package net.employee.employeeform.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Session {
    private int dataId;
    private String email;

    @Id
    @Column(name = "Data_ID", nullable = false)
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return dataId == session.dataId &&
                Objects.equals(email, session.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataId, email);
    }
}
