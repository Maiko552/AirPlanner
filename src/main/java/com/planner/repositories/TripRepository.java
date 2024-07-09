package com.planner.repositories;


import com.planner.domain.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
