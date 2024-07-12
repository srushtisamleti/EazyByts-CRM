package com.example.crmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crmsystem.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
