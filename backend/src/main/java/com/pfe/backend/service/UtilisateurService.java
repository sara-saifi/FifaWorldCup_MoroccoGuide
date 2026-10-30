
package com.pfe.backend.service;

import com.pfe.backend.entite.Utilisateur;
import com.pfe.backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setNomUtilisateur(utilisateurDetails.getNomUtilisateur());
            utilisateur.setPrenomUtilisateur(utilisateurDetails.getPrenomUtilisateur());
            utilisateur.setNationalite(utilisateurDetails.getNationalite());
            utilisateur.setEmailUtilisateur(utilisateurDetails.getEmailUtilisateur());
            utilisateur.setMotPasse(utilisateurDetails.getMotPasse());
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Utilisateur getUtilisateurByEmail(String email) {
        Utilisateur byEmailUtilisateur;
        byEmailUtilisateur = utilisateurRepository.findByEmailUtilisateur(email);
        return byEmailUtilisateur;
    }
}
