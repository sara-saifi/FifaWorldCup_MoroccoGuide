package com.pfe.backend.entite;

import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String nationalite;
    private String emailUtilisateur;
    private String motPasse;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private List<Reservation> reservations;

    public Utilisateur() {}

    public Utilisateur(Long id_utilisateur, String nom_utilisateur, String prenom_utilisateur,
                       String nationalite, String email_utilisateur, String mot_passe) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nationalite = nationalite;
        this.emailUtilisateur = emailUtilisateur;
        this.motPasse = motPasse;
    }

    public Long getIdUtilisateur() { return idUtilisateur; }
    public void setIdUtilisateur(Long idUtilisateur) { this.idUtilisateur = idUtilisateur; }

    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nom_utilisateur) { this.nomUtilisateur = nom_utilisateur; }

    public String getPrenomUtilisateur() { return prenomUtilisateur; }
    public void setPrenomUtilisateur(String prenomUtilisateur) { this.prenomUtilisateur = prenomUtilisateur; }

    public String getNationalite() { return nationalite; }
    public void setNationalite(String nationalite) { this.nationalite = nationalite; }

    public String getEmailUtilisateur() { return emailUtilisateur; }
    public void setEmailUtilisateur(String emailUtilisateur) { this.emailUtilisateur = emailUtilisateur; }

    public String getMotPasse() { return motPasse; }
    public void setMotPasse(String mot_passe) { this.motPasse = motPasse; }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
}
