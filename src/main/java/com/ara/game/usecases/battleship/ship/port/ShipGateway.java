package com.ara.game.usecases.battleship.ship.port;

import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;

import io.vavr.control.Option;

public interface ShipGateway {
    ShipOutputData save(ShipOutputData ship);
    Option<ShipOutputData> findById(String shipId);
    void remove(String shipId);
}
