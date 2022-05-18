package com.example.simplerestapiprojectplayers.controllers;

import com.example.simplerestapiprojectplayers.service.PlayerService;
import com.example.simplerestapiprojectplayers.view.PlayerViewModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public List<PlayerViewModel> allPlayers() {
        return this.playerService.getAllPlayers();
    }

    @GetMapping("/{name}")
    public PlayerViewModel findByName(@PathVariable String name) {
        return this.playerService.findPlayerByName(name);
    }

    @GetMapping("/position/{position}")
    public List<PlayerViewModel> findAllByPosition(@PathVariable String position) {
        return this.playerService.findAllByPosition(position);
    }

    @GetMapping("/number/{number}")
    public PlayerViewModel findByShirtNumber(@PathVariable Integer number) {
        return this.playerService.findByShirtNumber(number);
    }

    @GetMapping("/country/{country}")
    public List<PlayerViewModel> findAllByNationality(@PathVariable String country) {
        return this.playerService.findAllByCountry(country);
    }

    @PostMapping("/add")
    public PlayerViewModel addPlayer(@RequestBody PlayerViewModel playerViewModel) {
        this.playerService.addPlayer(playerViewModel);
        System.out.println();

        return playerViewModel;
    }

    @DeleteMapping("/delete/{number}")
    public PlayerViewModel deletePlayerByShirtNumber(@PathVariable Integer number) {

        return this.playerService.deletePlayer(number);
    }

    @PatchMapping("/update/{number}")
    public PlayerViewModel updatePlayer(@RequestBody PlayerViewModel playerViewModel, @PathVariable Integer number) {

        return this.playerService.updatePlayer(playerViewModel, number);
    }
}