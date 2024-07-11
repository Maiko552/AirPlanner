package com.planner.repositories.participant;

import com.planner.domain.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    //criando um método de busca por id
    List<Participant> findByTripId(UUID tripId);
}
