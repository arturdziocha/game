package com.ara.game.adapter.repository.battleship.inmemory.port;

import java.util.HashMap;
import java.util.Map;

import com.ara.game.adapter.repository.battleship.inmemory.entity.point.ShipInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.point.ShipMapper;
import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;

import io.vavr.control.Option;

public class ShipInMemoryGateway implements ShipGateway {
    private Map<String, ShipInMemory> entities;
    private final ShipMapper mapper;

    public ShipInMemoryGateway() {
        this.entities = new HashMap<>();
        this.mapper = new ShipMapper();
    }

    @Override
    public ShipOutputData save(ShipOutputData ship) {
        this.entities.put(ship.getId(), mapper.mapToEntity(ship));
        return ship;
    }

    @Override
    public Option<ShipOutputData> findById(String shipId) {
        return Option.of(entities.get(shipId)).map(mapper::mapToOutputData);
    }

    @Override
    public void remove(String shipId) {
        entities.remove(shipId);

    }

}
