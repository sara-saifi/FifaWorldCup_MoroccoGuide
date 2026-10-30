package com.pfe.backend.service;

import com.pfe.backend.entite.Restaurant;
import com.pfe.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.setNomRestaurant(restaurantDetails.getNomRestaurant());
            restaurant.setAdresseRestaurant(restaurantDetails.getAdresseRestaurant());
            restaurant.setType(restaurantDetails.getType());
            restaurant.setNomVille(restaurantDetails.getNomVille());
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getRestaurantsByVille(String nomVille) {
        return restaurantRepository.findByNomVille(nomVille);
    }
}

