package com.ara.game.adapter.repository.battleship.inmemory.port;

import com.ara.game.adapter.repository.battleship.inmemory.entity.GameInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.GameMapper;
import com.ara.game.usecases.battleship.game.dto.GameDTO;
import com.ara.game.usecases.battleship.game.port.GameGateway;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;

public class GameInMemoryGateway implements GameGateway {
    private Map<String, GameInMemory> entities;
    private GameMapper mapper;

    public GameInMemoryGateway() {
        this.entities = HashMap.empty();
        this.mapper = new GameMapper();
    }

    @Override
    public GameDTO create(GameDTO inputData) {
        entities = entities.put(inputData.getId(), mapper.mapToEntity(inputData));
        return inputData;
    }
}
