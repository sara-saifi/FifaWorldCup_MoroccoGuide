package com.pfe.backend.repository;

import com.pfe.backend.entite.Reservation;
import com.pfe.backend.entite.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Chercher toutes les réservations d'un utilisateur
    List<Reservation> findByUtilisateur(Utilisateur utilisateur);

    // Chercher les réservations par statut
    List<Reservation> findByStatut(String statut);

    List<Reservation> findByTypeReservation(String typeReservation);
}
