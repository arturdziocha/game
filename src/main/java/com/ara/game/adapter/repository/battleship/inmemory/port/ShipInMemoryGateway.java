package com.ara.game.adapter.repository.battleship.inmemory.port;

import java.util.HashMap;
import java.util.Map;

import com.ara.game.adapter.repository.battleship.inmemory.entity.ShipInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.ShipMapper;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;

import io.vavr.control.Option;

public class ShipInMemoryGateway implements ShipGateway {
    private Map<String, ShipInMemory> entities;
    private final ShipMapper mapper;
    private final ShipClassFacade shipClassFacade;
    private final 

    public ShipInMemoryGateway() {
        this.entities = new HashMap<>();
        this.mapper = new ShipMapper();
        this.shipClassFacade = new ShipClassFacade();

    }

    @Override
    public ShipOutputData save(ShipOutputData ship) {
        this.entities.put(ship.getId(), mapper.mapToEntity(ship));
        return ship;
    }

    @Override
    public Option<ShipOutputData> findById(String shipId) {
        Option<ShipInMemory> ship = Option.of(entities.get(shipId));
        if (ship.isEmpty()) {
            return Option.none();
        }
        return shipClassFacade
                .findByShortName(ship.get().getShipClassShortName())
                .map(s -> mapper.mapToOutputData(ship.get(), s))
                .toOption();

    }

    @Override
    public void remove(String shipId) {
        entities.remove(shipId);

    }

}
