package com.example.simplerestapiprojectplayers.repository;

import com.example.simplerestapiprojectplayers.model.entity.PlayerEntity;
import com.example.simplerestapiprojectplayers.model.entity.enums.PositionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    List<PlayerEntity> findAllByPosition(PositionEnum position);

    PlayerEntity findByShirtNumber(Integer shirtNumber);

    List<PlayerEntity> findAllByNationality(String nationality);

    Optional<PlayerEntity> findByName(String name);
}
