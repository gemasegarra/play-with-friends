package com.segarra.edgeserver.client;

import com.segarra.edgeserver.controller.dto.GameDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("games-service")
public interface GamesClient {
    @GetMapping("/games")
    List<GameDTO> showAll();
}
