package net.employee.employeeform.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Position {
    private int positionId;
    private String positionName;

    @Id
    @Column(name = "PositionID", nullable = false)
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "Position_Name", nullable = false, length = 255)
    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionId == position.positionId &&
                Objects.equals(positionName, position.positionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionId, positionName);
    }
}
