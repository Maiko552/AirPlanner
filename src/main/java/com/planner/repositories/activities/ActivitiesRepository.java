package com.planner.repositories.activities;

import com.planner.domain.activities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActivitiesRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findByTripId(UUID tripId);
}
