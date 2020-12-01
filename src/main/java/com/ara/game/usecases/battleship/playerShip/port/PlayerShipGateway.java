package com.ara.game.usecases.battleship.playerShip.port;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipCreateDTO;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;

import io.vavr.collection.Seq;
import io.vavr.control.Option;

public interface PlayerShipGateway {
    PlayerShipCreateDTO save(PlayerShipCreateDTO playerShip);

   
    Option<Seq<ShipWithPointsOutputData>> find(String playerId);

    Option<ShipOutputData> findByPlayerIdAndShipClassShortName(String playerId, String shipClass);

    Option<ShipOutputData> findByPlayerAndPointId(String playerId, String pointId);

    void removeAll(String playerId);

    void removeShip(String playerId, String shipId);
}
