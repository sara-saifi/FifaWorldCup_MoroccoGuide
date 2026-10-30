package com.pfe.backend.entite;

import javax.persistence.*;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    private String nomRestaurant;
    private String adresseRestaurant;
    private String type;
    private String nomVille;

    public Restaurant() {}

    public Restaurant(Long idRestaurant, String nomRestaurant, String adresseRestaurant, String type, String nomVille) {
        this.idRestaurant = idRestaurant;
        this.nomRestaurant = nomRestaurant;
        this.adresseRestaurant = adresseRestaurant;
        this.type = type;
        this.nomVille = nomVille;
    }

    public Long getIdRestaurant() { return idRestaurant; }
    public void setIdRestaurant(Long idRestaurant) { this.idRestaurant = idRestaurant; }

    public String getNomRestaurant() { return nomRestaurant; }
    public void setNomRestaurant(String nom_restaurant) { this.nomRestaurant = nom_restaurant; }

    public String getAdresseRestaurant() { return adresseRestaurant; }
    public void setAdresseRestaurant(String adresseRestaurant) { this.adresseRestaurant = adresseRestaurant; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getNomVille() { return nomVille; }
    public void setNomVille(String nomVille) { this.nomVille = nomVille; }
}
