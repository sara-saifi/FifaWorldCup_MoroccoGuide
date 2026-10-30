package com.pfe.backend.repository;

import com.pfe.backend.entite.Utilisateur;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Chercher un utilisateur par email
    Utilisateur findByEmailUtilisateur(String emailUtilisateur);
}
