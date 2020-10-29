package com.ara.game.adapter.repository.battleship.inmemory.port;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipInputData;
import com.ara.game.usecases.battleship.playerShip.port.PlayerShipGateway;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;

import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class PlayerShipInMemoryGateway implements PlayerShipGateway {

    @Override
    public PlayerShipInputData save(PlayerShipInputData playerShip) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Option<Seq<ShipOutputData>> find(String playerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Option<Seq<ShipWithPointsOutputData>> findWithPoints(String playerId) {
        // TODO Auto-generated method stub
        return null;
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
