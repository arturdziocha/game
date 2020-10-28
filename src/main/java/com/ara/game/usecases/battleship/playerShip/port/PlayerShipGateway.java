package com.ara.game.usecases.battleship.playerShip.port;

import java.util.List;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipInputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;

import io.vavr.control.Option;

public interface PlayerShipGateway {
    PlayerShipInputData save(PlayerShipInputData playerShip);

    Option<List<ShipOutputData>> find(String playerId);
    
    Option<List<ShipWithPointsOutputData>> findWithPoints(String playerId);

    Option<ShipOutputData> findByPlayerIdAndShipClassShortName(String playerId, String shipClass);

    Option<ShipOutputData> findByPlayerAndPointId(String playerId, String pointId);

    void removeAll(String playerId);

    void removeShip(String playerId, String shipId);
}
