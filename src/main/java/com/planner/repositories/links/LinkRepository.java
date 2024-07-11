package com.planner.repositories.links;

import com.planner.domain.links.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<Link, UUID> {
}
