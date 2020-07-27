package com.ara.game.usecases.battleship.ship.port;

import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;

public interface ShipGateway {
    ShipOutputData save(ShipOutputData ship);
}
