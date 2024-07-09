package com.planner.controller;

import com.planner.domain.participant.ParticipantService;
import com.planner.domain.trip.Trip;
import com.planner.domain.trip.TripRequestPayload;
import com.planner.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private TripRepository repository;

    @PostMapping
    public ResponseEntity<String> createTrip(@RequestBody TripRequestPayload payload){
        Trip newTrip = new Trip(payload);

        this.repository.save(newTrip);

        this.participantService.registerParticipantToEvent(payload.emails_to_invite(), newTrip.getId());

        return ResponseEntity.ok("Sucesso!");
    }
}