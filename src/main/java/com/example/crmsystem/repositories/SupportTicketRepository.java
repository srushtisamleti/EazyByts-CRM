package com.example.crmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crmsystem.models.SupportTicket;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long>{

}
