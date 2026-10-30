package com.pfe.backend.repository;

import com.pfe.backend.entite.Billets_matchs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Billets_matchsRepository extends JpaRepository<Billets_matchs, Long> {
    // Chercher les matchs par date
    List<Billets_matchs> findByDateMatchs(LocalDate dateMatchs);
}

