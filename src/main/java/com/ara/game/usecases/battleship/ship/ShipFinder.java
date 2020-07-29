package com.ara.game.usecases.battleship.ship;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.common.Error;
import io.vavr.control.Either;

final class ShipFinder {
    private final ShipGateway shipGateway;

    ShipFinder(ShipGateway shipGateway) {
        this.shipGateway = shipGateway;
    }
    Either<Error, ShipOutputData> findById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Either.left(ShipError.SHIP_ID_CANNOT_BE_EMPTY);
        } else {
            return shipGateway.findById(id).toEither(ShipError.SHIP_DOESNT_EXISTS);
        }
    }
}
