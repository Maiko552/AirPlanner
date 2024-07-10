package com.planner.service.participant;

import com.planner.domain.participant.Participant;
import com.planner.domain.participant.ParticipantCreateResponse;
import com.planner.domain.trip.Trip;
import com.planner.repositories.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    public void registerParticipantToEvent(List<String> participantsToInvite, Trip trip){
       List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

       this.repository.saveAll(participants);

        System.out.printf(String.valueOf((participants.get(0).getId())));
    }

    public ParticipantCreateResponse registerOneParticipantToEvent(String email, Trip trip){
        Participant newParticipant = new Participant(email, trip    );
        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){}

    public void triggerConfirmationEmailToOneParticipant(String email){}
}
