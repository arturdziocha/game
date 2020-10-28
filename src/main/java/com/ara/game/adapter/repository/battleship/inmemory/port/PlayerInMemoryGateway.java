package com.ara.game.adapter.repository.battleship.inmemory.port;

import java.util.HashMap;
import java.util.Map;

import com.ara.game.adapter.repository.battleship.inmemory.entity.PlayerInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.PlayerMapper;
import com.ara.game.usecases.battleship.player.dtos.PlayerOutputAllData;
import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;

import io.vavr.control.Option;

public class PlayerInMemoryGateway implements PlayerGateway {
    private Map<String, PlayerInMemory> entities;
    private PlayerMapper mapper;

    public PlayerInMemoryGateway() {
        this.entities = new HashMap<>();
        this.mapper = new PlayerMapper();
    }

    @Override
    public PlayerOutputData save(PlayerOutputData inputData) {
        entities.put(inputData.getId(), mapper.mapToEntity(inputData));
        return inputData;
    }

    @Override
    public Option<PlayerOutputData> findById(String id) {
        return Option.of(entities.get(id)).map(mapper::mapToOutputData);
    }

    @Override
    public Option<PlayerOutputAllData> findAllData(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
