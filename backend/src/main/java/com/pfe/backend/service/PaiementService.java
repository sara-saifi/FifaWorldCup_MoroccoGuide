package com.pfe.backend.service;

import com.pfe.backend.entite.Paiement;
import com.pfe.backend.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Optional<Paiement> getPaiementById(Long id) {
        return paiementRepository.findById(id);
    }

    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement updatePaiement(Long id, Paiement paiementDetails) {
        Optional<Paiement> optionalPaiement = paiementRepository.findById(id);
        if (optionalPaiement.isPresent()) {
            Paiement paiement = optionalPaiement.get();
            paiement.setMontant(paiementDetails.getMontant());
            paiement.setDatePaiement(paiementDetails.getDatePaiement());
            paiement.setModePaiement(paiementDetails.getModePaiement());
            return paiementRepository.save(paiement);
        }
        return null;
    }

    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }
}
