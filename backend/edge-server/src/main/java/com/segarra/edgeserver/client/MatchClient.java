package com.segarra.edgeserver.client;

import com.segarra.edgeserver.classes.MatchRequest;
import com.segarra.edgeserver.controller.dto.MatchInputDTO;
import com.segarra.edgeserver.controller.dto.MatchServiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("matching-service")
public interface MatchClient {
    @PostMapping("/matching")
    MatchInputDTO createMatchRequest(@RequestBody MatchServiceDTO matchDTO);

    @DeleteMapping("/matching/{id}")
    void deleteMatch(@PathVariable Long id);

    @GetMapping("/matching")
    List<MatchRequest> findAll();

    @GetMapping("/matching/{id}")
    MatchRequest findMatch(@PathVariable Long id);

    @PostMapping("/matching/{id}")
    MatchRequest updateMatch(@RequestBody Long matcher, @PathVariable Long id);
}
