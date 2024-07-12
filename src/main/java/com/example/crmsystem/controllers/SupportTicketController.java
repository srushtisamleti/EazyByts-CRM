package com.example.crmsystem.controllers;

import com.example.crmsystem.models.SupportTicket;
import com.example.crmsystem.repositories.SupportTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/support-tickets")
public class SupportTicketController {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicket> getSupportTicketById(@PathVariable Long id) {
        Optional<SupportTicket> supportTicket = supportTicketRepository.findById(id);
        return supportTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SupportTicket> createSupportTicket(@RequestBody SupportTicket supportTicket) {
        SupportTicket savedSupportTicket = supportTicketRepository.save(supportTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSupportTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id, @RequestBody SupportTicket supportTicketDetails) {
        Optional<SupportTicket> supportTicket = supportTicketRepository.findById(id);
        if (supportTicket.isPresent()) {
            SupportTicket existingSupportTicket = supportTicket.get();
            existingSupportTicket.setIssue(supportTicketDetails.getIssue());
            existingSupportTicket.setStatus(supportTicketDetails.getStatus());
            SupportTicket updatedSupportTicket = supportTicketRepository.save(existingSupportTicket);
            return ResponseEntity.ok(updatedSupportTicket);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
        if (supportTicketRepository.existsById(id)) {
            supportTicketRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
