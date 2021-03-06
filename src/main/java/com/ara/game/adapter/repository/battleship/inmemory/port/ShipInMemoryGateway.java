package com.ara.game.adapter.repository.battleship.inmemory.port;

import java.util.HashMap;
import java.util.Map;

import com.ara.game.adapter.repository.battleship.inmemory.entity.ShipInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.ShipMapper;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;
import com.google.inject.Inject;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class ShipInMemoryGateway implements ShipGateway {
    private Map<String, ShipInMemory> entities;
    private final ShipMapper mapper;
    private final ShipClassFacade shipClassFacade;
    private final ShipPointsGateway shipPointsGateway;

    @Inject
    public ShipInMemoryGateway(ShipPointsGateway shipPointsGateway) {
        this.entities = new HashMap<>();
        this.mapper = new ShipMapper();
        this.shipPointsGateway = shipPointsGateway;
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
    public Option<Seq<ShipWithPointsOutputData>> findAllById(Seq<String> ids) {
        Seq<ShipWithPointsOutputData> ships = List.empty();
        for (String id : ids) {
            Option<ShipWithPointsOutputData> ship = findByIdWithPoints(id);
            if (ship.isEmpty()) {
                return Option.none();
            }
            ships = ships.append(ship.get());
        }
        return Option.of(ships);
    }

    @Override
    public void remove(String shipId) {
        entities.remove(shipId);

    }

    @Override
    public Option<ShipWithPointsOutputData> findByIdWithPoints(String shipId) {
        Option<ShipOutputData> ship = findById(shipId);
        if (ship.isEmpty()) {
            return Option.none();
        }
        Option<ShipPointsOutputData> points = shipPointsGateway.findByShipId(shipId);
        return points.map(p -> mapper.mapToOutputDataWithPoints(ship.get(), p)).toOption();
    }

}
