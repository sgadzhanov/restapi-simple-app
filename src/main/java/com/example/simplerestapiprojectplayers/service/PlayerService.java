package com.example.simplerestapiprojectplayers.service;

import com.example.simplerestapiprojectplayers.view.PlayerViewModel;

import java.util.List;

public interface PlayerService {
    void initialisePlayers();

    List<PlayerViewModel> getAllPlayers();

    List<PlayerViewModel> findAllByPosition(String position);

    PlayerViewModel findByShirtNumber(Integer number);

    List<PlayerViewModel> findAllByCountry(String country);

    PlayerViewModel findPlayerByName(String name);

    void addPlayer(PlayerViewModel playerViewModel);

    PlayerViewModel deletePlayer(Integer number);

    PlayerViewModel updatePlayer(PlayerViewModel playerViewModel, Integer shirtNumber);
}