package com.planner.service.links;

import com.planner.domain.activities.ActivityData;
import com.planner.domain.links.Link;
import com.planner.domain.links.LinkData;
import com.planner.domain.links.LinkRequestPayload;
import com.planner.domain.links.LinkResponse;
import com.planner.domain.trip.Trip;
import com.planner.repositories.links.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository repository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip){
        Link newLink = new Link(payload.title(), payload.url(), trip);

        this.repository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getAllLinksFromTrip(UUID tripId){
        return this.repository.findByTripId(tripId).stream().map(link -> new LinkData(link.getId(), link.getTitle(), link.getUrl())).toList();
    }
}
