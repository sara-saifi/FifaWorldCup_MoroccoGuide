package com.pfe.backend.entite;

import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private String email;
    private String motPasse;

    public Admin() {}

    public Admin(Long idAdmin, String nomAdmin, String prenomAdmin, String email, String motPasse) {
        this.idAdmin = idAdmin;
        this.nomAdmin = nomAdmin;
        this.prenomAdmin = prenomAdmin;
        this.email = email;
        this.motPasse = motPasse;
    }

    public Long getIdAdmin() { return idAdmin; }
    public void setIdAdmin(Long idAdmin) { this.idAdmin = idAdmin; }

    public String getNomAdmin() { return nomAdmin; }
    public void setNomAdmin(String nomAdmin) { this.nomAdmin = nomAdmin; }

    public String getPrenomAdmin() { return prenomAdmin; }
    public void setPrenomAdmin(String prenomAdmin) { this.prenomAdmin = prenomAdmin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotPasse() { return motPasse; }
    public void setMotPasse(String motPasse) { this.motPasse = motPasse; }
}
