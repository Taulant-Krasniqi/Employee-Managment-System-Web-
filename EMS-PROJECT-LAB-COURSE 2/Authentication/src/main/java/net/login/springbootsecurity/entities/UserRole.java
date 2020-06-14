package net.login.springbootsecurity.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "login")
public class UserRole {
    private int id;
    private int userId;
    private int roleId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                userId == userRole.userId &&
                roleId == userRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }
}
