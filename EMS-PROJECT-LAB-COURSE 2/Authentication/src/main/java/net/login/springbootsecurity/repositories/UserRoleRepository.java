package net.login.springbootsecurity.repositories;

import net.login.springbootsecurity.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {


}
