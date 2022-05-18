package com.example.simplerestapiprojectplayers.service.impl;

import com.example.simplerestapiprojectplayers.model.entity.PlayerEntity;
import com.example.simplerestapiprojectplayers.model.entity.enums.PositionEnum;
import com.example.simplerestapiprojectplayers.repository.PlayerRepository;
import com.example.simplerestapiprojectplayers.service.PlayerService;
import com.example.simplerestapiprojectplayers.view.PlayerViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initialisePlayers() {
        if (this.playerRepository.count() != 0) {
            return;
        }
        allPlayersInitialised();
    }

    @Override
    public List<PlayerViewModel> getAllPlayers() {
        return this.playerRepository
                .findAll()
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerViewModel findByShirtNumber(Integer number) {
        PlayerEntity player = this.playerRepository.findByShirtNumber(number);

        return this.modelMapper.map(player, PlayerViewModel.class);
    }

    @Override
    public List<PlayerViewModel> findAllByCountry(String country) {
        return this.playerRepository
                .findAllByNationality(country)
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());

    }

    @Override
    public PlayerViewModel findPlayerByName(String name) {
        PlayerEntity player = this.playerRepository
                .findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Player not found!"));

        return this.modelMapper.map(player, PlayerViewModel.class);
    }

    @Override
    public void addPlayer(PlayerViewModel playerViewModel) {
        PlayerEntity playerEntity = this.modelMapper.map(playerViewModel, PlayerEntity.class);

        this.playerRepository.save(playerEntity);
    }

    @Override
    public PlayerViewModel deletePlayer(Integer number) {
        PlayerEntity byShirtNumber = this.playerRepository.findByShirtNumber(number);

        this.playerRepository.delete(byShirtNumber);

        return this.modelMapper.map(byShirtNumber, PlayerViewModel.class);
    }

    @Override
    public PlayerViewModel updatePlayer(PlayerViewModel playerViewModel, Integer shirtNumber) {
        PlayerEntity playerFound = this.playerRepository.findByShirtNumber(shirtNumber);

        playerFound
                .setName(playerViewModel.getName())
                .setPosition(playerViewModel.getPosition())
                .setShirtNumber(playerViewModel.getShirtNumber());

        this.playerRepository.save(playerFound);


        return this.modelMapper.map(playerFound, PlayerViewModel.class);
    }


    @Override
    public List<PlayerViewModel> findAllByPosition(String position) {

        switch (position) {
            case "goalkeepers":
                return findAllGoalkeepers();
            case "defenders":
                return findAllDefenders();
            case "midfielders":
                return findAllMidfielders();
            case "forwards":
                return findAllForwards();
        }
        throw new IllegalStateException("Please try again.");
    }

    private List<PlayerViewModel> findAllGoalkeepers() {
        return this.playerRepository
                .findAllByPosition(PositionEnum.GOALKEEPER)
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());
    }

    private List<PlayerViewModel> findAllDefenders() {
        return this.playerRepository
                .findAllByPosition(PositionEnum.DEFENDER)
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());
    }

    private List<PlayerViewModel> findAllMidfielders() {
        return this.playerRepository
                .findAllByPosition(PositionEnum.MIDFIELDER)
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());
    }

    private List<PlayerViewModel> findAllForwards() {
        return this.playerRepository
                .findAllByPosition(PositionEnum.FORWARD)
                .stream()
                .map(playerEntity -> this.modelMapper.map(playerEntity, PlayerViewModel.class))
                .collect(Collectors.toList());
    }

    private void allPlayersInitialised() {
        PlayerEntity ali = new PlayerEntity(); // Alisson
        ali.setName("Alisson Becker")
                .setNationality("Brazil")
                .setPosition(PositionEnum.GOALKEEPER)
                .setShirtNumber(1);
        PlayerEntity kelleher = new PlayerEntity(); // Kelleher
        kelleher.setName("Caoimhin Kelleher")
                .setPosition(PositionEnum.GOALKEEPER)
                .setNationality("Ireland")
                .setShirtNumber(62);
        PlayerEntity vvd = new PlayerEntity(); // Van Dijk
        vvd.setName("Virgil Van Dijk")
                .setNationality("Netherlands")
                .setPosition(PositionEnum.DEFENDER)
                .setShirtNumber(4);
        PlayerEntity konate = new PlayerEntity(); // Konate
        konate.setName("Ibrahima Konate")
                .setNationality("France")
                .setPosition(PositionEnum.DEFENDER)
                .setShirtNumber(5);
        PlayerEntity matip = new PlayerEntity(); // Matip
        matip.setName("Joel Matip")
                .setNationality("Cameroon")
                .setShirtNumber(32)
                .setPosition(PositionEnum.DEFENDER);
        PlayerEntity trent = new PlayerEntity(); // Trent
        trent.setName("Trent Alexander Arnold")
                .setNationality("England")
                .setPosition(PositionEnum.DEFENDER)
                .setShirtNumber(66);
        PlayerEntity robbo = new PlayerEntity(); //Robertson
        robbo.setName("Andrew Robertson")
                .setNationality("Scotland")
                .setPosition(PositionEnum.DEFENDER)
                .setShirtNumber(26);
        PlayerEntity greekScouser = new PlayerEntity(); // Tsimi
        greekScouser.setName("Konstantinos Tsimikas")
                .setNationality("Greece")
                .setPosition(PositionEnum.DEFENDER)
                .setShirtNumber(21);
        PlayerEntity fab = new PlayerEntity(); // Fabinho
        fab.setName("Fabinho")
                .setNationality("Brazil")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(3);
        PlayerEntity thiago = new PlayerEntity(); //thiago
        thiago.setName("Thiago Alcantara")
                .setNationality("Spain")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(6);
        PlayerEntity milner = new PlayerEntity(); // milner
        milner.setName("James Milner")
                .setNationality("England")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(7);
        PlayerEntity naby = new PlayerEntity(); // keita
        naby.setName("Naby Keita")
                .setNationality("Guinea")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(8);
        PlayerEntity hendo = new PlayerEntity(); //hendo
        hendo.setName("Jordan Henderson")
                .setNationality("England")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(14);
        PlayerEntity curtis = new PlayerEntity();//curtis
        curtis.setName("Curtis Jones")
                .setPosition(PositionEnum.MIDFIELDER)
                .setNationality("England")
                .setShirtNumber(17);
        PlayerEntity firmino = new PlayerEntity();//firmino
        firmino.setName("Roberto Firmino")
                .setNationality("Brazil")
                .setPosition(PositionEnum.FORWARD)
                .setShirtNumber(9);
        PlayerEntity mane = new PlayerEntity(); //mane
        mane.setName("Sadio Mane")
                .setNationality("Senegal")
                .setPosition(PositionEnum.FORWARD)
                .setShirtNumber(10);
        PlayerEntity salah = new PlayerEntity();//salah
        salah.setName("Mohamed Salah")
                .setNationality("Egypt")
                .setPosition(PositionEnum.FORWARD)
                .setShirtNumber(11);
        PlayerEntity jota = new PlayerEntity();//jota
        jota.setName("Diogo Jota")
                .setNationality("Portugal")
                .setPosition(PositionEnum.FORWARD)
                .setShirtNumber(20);
        PlayerEntity diaz = new PlayerEntity();//diaz
        diaz.setName("Luis Diaz")
                .setNationality("Colombia")
                .setPosition(PositionEnum.FORWARD)
                .setShirtNumber(23);
        PlayerEntity harvey = new PlayerEntity();//elliott
        harvey.setName("Harvey Elliott")
                .setNationality("England")
                .setPosition(PositionEnum.MIDFIELDER)
                .setShirtNumber(67);

        this.playerRepository.saveAll(Arrays.asList(
                ali, kelleher, vvd, konate,
                matip, trent, robbo, greekScouser,
                fab, thiago, naby, milner, hendo,
                curtis, firmino, mane, salah,
                jota, diaz, harvey));
    }
}