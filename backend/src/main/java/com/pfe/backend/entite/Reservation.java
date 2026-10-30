package com.pfe.backend.entite;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateReservation;
    private String typeReservation;
    private double prix;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    public Reservation() {}

    public Reservation(Long idReservation, LocalDate dateReservation, String typeReservation,
                       double prix, String statut, Utilisateur utilisateur) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.typeReservation = typeReservation;
        this.prix = prix;
        this.statut = statut;
        this.utilisateur = utilisateur;
    }

    public Long getIdReservation() { return idReservation; }
    public void setIdReservation(Long idReservation) { this.idReservation = idReservation; }

    public LocalDate getDateReservation() { return dateReservation; }
    public void setDateReservation(LocalDate dateReservation) { this.dateReservation = dateReservation; }

    public String getTypeReservation() { return typeReservation; }
    public void setTypeReservation(String typeReservation) { this.typeReservation = typeReservation; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
}
