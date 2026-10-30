package com.pfe.backend.entite;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Billets_matchs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatchs;
    private LocalDate dateMatchs;
    private LocalTime heure;
    private String equipe1;
    private String equipe2;
    private String nomStade;

    public Billets_matchs() {}

    public Billets_matchs(Long idMatchs, LocalDate dateMatchs, LocalTime heure, String equipe1, String equipe2, String nomStade) {
        this.idMatchs = idMatchs;
        this.dateMatchs = dateMatchs;
        this.heure = heure;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.nomStade = nomStade;
    }

    public Long getIdMatchs() { return idMatchs; }
    public void setIdMatchs(Long idMatchs) { this.idMatchs = idMatchs; }

    public LocalDate getDateMatchs() { return dateMatchs; }
    public void setDateMatchs(LocalDate dateMatchs) { this.dateMatchs = dateMatchs; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public String getEquipe1() { return equipe1; }
    public void setEquipe1(String equipe1) { this.equipe1 = equipe1; }

    public String getEquipe2() { return equipe2; }
    public void setEquipe2(String equipe2) { this.equipe2 = equipe2; }

    public String getNomStade() { return nomStade; }
    public void setNomStade(String nomStade) { this.nomStade = nomStade; }
}
