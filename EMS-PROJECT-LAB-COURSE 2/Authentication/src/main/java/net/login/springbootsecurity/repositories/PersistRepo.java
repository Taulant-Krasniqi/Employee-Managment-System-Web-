package net.login.springbootsecurity.repositories;

import net.login.springbootsecurity.entities.PersistentLogins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


@Repository
public interface PersistRepo extends JpaRepository<PersistentLogins,String> {


    PersistentLogins findByUsername(String name);
}
