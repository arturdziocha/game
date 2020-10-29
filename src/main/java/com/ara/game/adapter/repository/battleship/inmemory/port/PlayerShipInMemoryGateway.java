package com.ara.game.adapter.repository.battleship.inmemory.port;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipInputData;
import com.ara.game.usecases.battleship.playerShip.port.PlayerShipGateway;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class PlayerShipInMemoryGateway implements PlayerShipGateway {
    private Map<String, Seq<String>> entities;
    private final ShipGateway shipGateway;

    public PlayerShipInMemoryGateway(ShipGateway shipGateway) {
        this.shipGateway = shipGateway;
        this.entities = HashMap.empty();
    }

    @Override
    public PlayerShipInputData save(PlayerShipInputData playerShip) {
        if (entities.containsKey(playerShip.getPlayerId())) {
            Seq<String> old = entities.get(playerShip.getPlayerId()).get();
            entities = entities.replaceValue(playerShip.getPlayerId(), old.append(playerShip.getShipId()));
        } else {
            entities = entities.put(playerShip.getPlayerId(), List.of(playerShip.getShipId()));
        }
        return playerShip;
    }

    @Override
    public Option<Seq<ShipWithPointsOutputData>> find(String playerId) {
        return entities.get(playerId).flatMap(s -> shipGateway.findAllById(s));
    }

    @Override
    public Option<ShipOutputData> findByPlayerIdAndShipClassShortName(String playerId, String shipClass) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Option<ShipOutputData> findByPlayerAndPointId(String playerId, String pointId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeAll(String playerId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeShip(String playerId, String shipId) {
        // TODO Auto-generated method stub

    }

}
