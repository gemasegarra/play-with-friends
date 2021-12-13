package com.segarra.edgeserver.client;

import com.segarra.edgeserver.classes.User;
import com.segarra.edgeserver.controller.dto.GameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient("games-service")
public interface GamesClient {
    @GetMapping("/games")
    List<GameDTO> showAll(@RequestParam String type, @RequestParam String name);
    @GetMapping("/games/{id}")
    GameDTO findById(@PathVariable Long id);
}
