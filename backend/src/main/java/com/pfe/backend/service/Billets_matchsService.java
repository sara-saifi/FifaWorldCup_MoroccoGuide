package com.pfe.backend.service;

import com.pfe.backend.entite.Billets_matchs;
import com.pfe.backend.repository.Billets_matchsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class Billets_matchsService {

    @Autowired
    private Billets_matchsRepository matchsRepository;

    public List<Billets_matchs> getAllMatchs() {
        return matchsRepository.findAll();
    }

    public Optional<Billets_matchs> getMatchById(Long id) {
        return matchsRepository.findById(id);
    }

    public Billets_matchs createMatch(Billets_matchs match) {
        return matchsRepository.save(match);
    }

    public Billets_matchs updateMatch(Long id, Billets_matchs matchDetails) {
        Optional<Billets_matchs> optionalMatch = matchsRepository.findById(id);
        if (optionalMatch.isPresent()) {
            Billets_matchs match = optionalMatch.get();
            match.setDateMatchs(matchDetails.getDateMatchs());
            match.setHeure(matchDetails.getHeure());
            match.setEquipe1(matchDetails.getEquipe1());
            match.setEquipe2(matchDetails.getEquipe2());
            match.setNomStade(matchDetails.getNomStade());
            return matchsRepository.save(match);
        }
        return null;
    }

    public void deleteMatch(Long id) {
        matchsRepository.deleteById(id);
    }

    public List<Billets_matchs> getMatchsByDate(LocalDate date) {
        return matchsRepository.findByDateMatchs(date);
    }
}
