package net.login.springbootsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.login.springbootsecurity.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
