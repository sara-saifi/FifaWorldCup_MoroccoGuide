package com.pfe.backend.repository;

import com.pfe.backend.entite.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // Méthode pour récupérer tous les restaurants d'une ville spécifique
    List<Restaurant> findByNomVille(String nomVille);

    // Tu peux ajouter d'autres méthodes personnalisées si nécessaire
    // Exemple : findByType(String type);
}
