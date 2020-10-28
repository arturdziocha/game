package com.ara.game.usecases.battleship.ship.port;

import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;

import io.vavr.control.Option;

public interface ShipGateway {
    ShipOutputData save(ShipOutputData ship);
    Option<ShipOutputData> findById(String shipId);
    Option<ShipWithPointsOutputData> findByIdWithPoints(String shipId);
    void remove(String shipId);
}
