package com.ara.game.usecases.battleship.shipPoints;

import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;
import io.vavr.control.Option;

final class ShipPointsCreator {
    private final ShipPointsGateway shipPointsGateway;
    private final ShipPointsValidator validator;

    ShipPointsCreator(ShipPointsGateway shipPointsGateway) {
        this.shipPointsGateway = shipPointsGateway;
        this.validator = new ShipPointsValidator();
    }

    Either<Error, ShipPointsCreateInputData> createPoints(ShipPointsCreateInputData shipPoints) {
        Option<Error> validated = validator.validateAll(shipPoints);       

        if (validated.isEmpty()) {
            ShipPointsCreateInputData dto = shipPointsGateway.saveAll(shipPoints);
            return Either.right(dto);
        }
        return Either.left(validated.get());
    }
    //TODO create from random point
}
