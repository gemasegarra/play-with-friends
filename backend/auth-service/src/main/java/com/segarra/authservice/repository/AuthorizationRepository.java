package com.segarra.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.segarra.authservice.model.Authorization;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {
}
