package com.ara.game.usecases.battleship.shipPoints;

import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

public final class ShipPointsFacade {
    private final ShipPointsCreator creator;
    private final ShipPointsFinder finder;
    private final ShipPointsRemover remover;

    public ShipPointsFacade(ShipPointsGateway shipPointsGateway) {
        this.creator = new ShipPointsCreator(shipPointsGateway);
        this.finder = new ShipPointsFinder(shipPointsGateway);
        this.remover = new ShipPointsRemover(shipPointsGateway);
    }
    public Either<Error, ShipPointsCreateInputData> placePoints(ShipPointsCreateInputData shipPoints) {
        return creator.createPoints(shipPoints);
    }

    public Either<Error, ShipPointsOutputData> findPoints(String shipId) {
        return finder.findPoints(shipId);
    }

    public Either<Error, String> remove(String shipId) {
        return remover.remove(shipId);
    }
}
