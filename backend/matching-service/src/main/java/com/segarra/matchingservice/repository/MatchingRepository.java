package com.segarra.matchingservice.repository;

import com.segarra.matchingservice.model.MatchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingRepository extends JpaRepository<MatchRequest, Long> {
}
