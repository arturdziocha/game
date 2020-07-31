package com.ara.game.usecases.battleship.shipPoints;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

final class ShipPointsRemover {
    private final ShipPointsGateway shipPointsGateway;

    public ShipPointsRemover(ShipPointsGateway shipPointsGateway) {
        this.shipPointsGateway = shipPointsGateway;
    }

    public Either<Error, String> remove(String shipId) {
        if (StringUtils.isEmpty(shipId)) {
            return Either.left(ShipPointsError.DATA_CANNOT_BE_NULL);
        }
        shipPointsGateway.remove(shipId);
        return Either.right("Ship points deleted");
    }
}
