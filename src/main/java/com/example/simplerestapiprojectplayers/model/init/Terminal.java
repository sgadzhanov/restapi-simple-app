package com.example.simplerestapiprojectplayers.model.init;

import com.example.simplerestapiprojectplayers.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {
    private final PlayerService playerService;


    public Terminal(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.playerService.initialisePlayers();
    }
}