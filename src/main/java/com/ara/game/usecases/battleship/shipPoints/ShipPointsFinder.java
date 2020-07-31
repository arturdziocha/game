package com.ara.game.usecases.battleship.shipPoints;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

final class ShipPointsFinder {
    private final ShipPointsGateway shipPointsGateway;

    ShipPointsFinder(ShipPointsGateway shipPointsGateway) {
        this.shipPointsGateway = shipPointsGateway;
    }

    Either<Error, ShipPointsOutputData> findPoints(String shipId) {
        if (StringUtils.isEmpty(shipId)) {
            return Either.left(ShipPointsError.DATA_CANNOT_BE_NULL);
        }
        return shipPointsGateway.findByShipId(shipId).toEither(ShipPointsError.CANNOT_FIND_RELATED_POINTS);
    }
}
