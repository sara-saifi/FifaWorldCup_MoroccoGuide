package com.pfe.backend.repository;

import com.pfe.backend.entite.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Chercher les hôtels par ville
    List<Hotel> findByNomVille(String nomVille);
}

