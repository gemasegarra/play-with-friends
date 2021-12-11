package com.segarra.matchingservice.repository;

import com.segarra.matchingservice.model.MatchUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMatchedRepository extends JpaRepository<MatchUser, Long> {
}
