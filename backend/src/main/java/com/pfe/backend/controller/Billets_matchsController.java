package com.pfe.backend.controller;

import com.pfe.backend.entite.Billets_matchs;
import com.pfe.backend.service.Billets_matchsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matchs")
@CrossOrigin(origins = "*")
public class Billets_matchsController {

    @Autowired
    private Billets_matchsService matchsService;

    @GetMapping
    public List<Billets_matchs> getAllMatchs() {
        return matchsService.getAllMatchs();
    }

    @GetMapping("/{id}")
    public Optional<Billets_matchs> getMatchById(@PathVariable Long id) {
        return matchsService.getMatchById(id);
    }

    @PostMapping
    public Billets_matchs createMatch(@RequestBody Billets_matchs match) {
        return matchsService.createMatch(match);
    }

    @PutMapping("/{id}")
    public Billets_matchs updateMatch(@PathVariable Long id, @RequestBody Billets_matchs matchDetails) {
        return matchsService.updateMatch(id, matchDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchsService.deleteMatch(id);
    }

    @GetMapping("/date/{date}")
    public List<Billets_matchs> getMatchsByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return matchsService.getMatchsByDate(localDate);
    }
}
