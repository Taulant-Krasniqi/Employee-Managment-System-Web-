package com.AdminDashboard.AdminForm.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


public class Position {
    private int positionId;
    private String positionName;


    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }


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
