package com.planner.service.Activities;

import com.planner.domain.activities.Activity;
import com.planner.domain.activities.ActivityData;
import com.planner.domain.activities.ActivityRequestPayload;
import com.planner.domain.activities.ActivityResponse;
import com.planner.domain.participant.ParticipantData;
import com.planner.domain.trip.Trip;
import com.planner.repositories.activities.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivitiesRepository repository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip){
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.repository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }

    public List<ActivityData> getAllActivitiesFromId(UUID tripId){
        return this.repository.findByTripId(tripId).stream().map(activity -> new ActivityData(activity.getId(), activity.getTitle(), activity.getOccursAt())).toList();
    }

}
