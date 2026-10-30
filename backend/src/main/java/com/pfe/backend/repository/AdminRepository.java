package com.pfe.backend.repository;

import com.pfe.backend.entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Méthode pour chercher un admin par email
    Admin findByEmail(String email);
}
