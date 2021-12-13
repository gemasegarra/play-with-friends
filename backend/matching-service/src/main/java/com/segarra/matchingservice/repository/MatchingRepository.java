package com.segarra.matchingservice.repository;

import com.segarra.matchingservice.model.MatchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchingRepository extends JpaRepository<MatchRequest, Long> {
    List<MatchRequest> findByUserId(Long user);

    @Query("SELECT mr FROM MatchRequest mr WHERE mr.id IN (SELECT mu.matchingRequest FROM MatchUser mu WHERE mu.matcher = ?1)")
    List<MatchRequest> findByMatcherId(Long matcherId);
}
