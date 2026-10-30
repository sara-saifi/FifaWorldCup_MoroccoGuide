package com.pfe.backend.repository;

import com.pfe.backend.entite.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    // Chercher les paiements par date
    List<Paiement> findByDatePaiement(LocalDate datePaiement);
}
