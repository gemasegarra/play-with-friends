package com.segarra.edgeserver.client;

import com.segarra.edgeserver.classes.Match;
import com.segarra.edgeserver.controller.dto.MatchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("matching-service")
public interface MatchClient {
    @PostMapping("/matches")
    MatchDTO createMatchRequest(@RequestBody MatchDTO matchDTO);

    @DeleteMapping("/matches/{id}")
    void deleteMatch(@PathVariable Long id);

    @GetMapping("/matches")
    List<MatchDTO> showAll();

    @GetMapping("/matches/{id}")
    Match findMatch(@PathVariable Long id);

    @PostMapping("/matches/{id}")
    Match updateMatch(@PathVariable Long id, @RequestBody Long match);
}
