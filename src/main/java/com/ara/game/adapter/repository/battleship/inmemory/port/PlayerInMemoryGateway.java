package com.ara.game.adapter.repository.battleship.inmemory.port;


import com.ara.game.adapter.repository.battleship.inmemory.entity.PlayerInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.PlayerMapper;
import com.ara.game.usecases.battleship.player.dto.PlayerAllDataDTO;
import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;

public class PlayerInMemoryGateway implements PlayerGateway {
    private Map<String, PlayerInMemory> entities;
    private PlayerMapper mapper;

    public PlayerInMemoryGateway() {
        this.entities = HashMap.empty();
        this.mapper = new PlayerMapper();
    }

    @Override
    public PlayerDTO save(PlayerDTO inputData) {
        entities = entities.put(inputData.getId(), mapper.mapToEntity(inputData));
        return inputData;
    }

    @Override
    public Option<PlayerDTO> findById(String id) {
        return entities.get(id).map(mapper::mapToOutputData);
    }

    @Override
    public Option<PlayerAllDataDTO> findAllData(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
