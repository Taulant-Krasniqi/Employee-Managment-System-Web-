package net.login.springbootsecurity.repositories;

import java.util.Optional;

import net.login.springbootsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByEmail(String email);



	User findByName(String name);

}
