package com.pfe.backend.entite;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHotel;
    private String nomHotel;
    private String adresseHotel;
    private String nomVille;

    public Hotel() {}

    public Hotel(Long idHotel, String nomHotel, String adresseHotel, String nomVille) {
        this.idHotel = idHotel;
        this.nomHotel = nomHotel;
        this.adresseHotel = adresseHotel;
        this.nomVille = nomVille;
    }

    public Long getIdHotel() { return idHotel; }
    public void setIdHotel(Long idHotel) { this.idHotel = idHotel; }

    public String getNomHotel() { return nomHotel; }
    public void setNomHotel(String nomHotel) { this.nomHotel = nomHotel; }

    public String getAdresseHotel() { return adresseHotel; }
    public void setAdresseHotel(String adresseHotel) { this.adresseHotel = adresseHotel; }

    public String getNomVille() { return nomVille; }
    public void setNomVille(String nomVille) { this.nomVille = nomVille; }
}
