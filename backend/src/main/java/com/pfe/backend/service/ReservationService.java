package com.pfe.backend.service;

import com.pfe.backend.entite.Reservation;
import com.pfe.backend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setDateReservation(reservationDetails.getDateReservation());
            reservation.setTypeReservation(reservationDetails.getTypeReservation());
            reservation.setPrix(reservationDetails.getPrix());
            reservation.setStatut(reservationDetails.getStatut());
            reservation.setUtilisateur(reservationDetails.getUtilisateur());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByType(String typeReservation) {
        return reservationRepository.findByTypeReservation(typeReservation);
    }
}

