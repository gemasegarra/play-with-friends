package com.segarra.matchingservice.repository;

import com.segarra.matchingservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingRepository extends JpaRepository<Match, Long> {
}
