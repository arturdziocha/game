package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.battleship.ship.dto.ShipCreateInputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;
import com.google.inject.Inject;

import io.vavr.control.Either;

public final class ShipFacade {
    private final ShipCreator creator;
    private final ShipFinder finder;
    private final ShipRemover remover;

    @Inject
    public ShipFacade(ShipGateway shipGateway, IdGenerator idGenerator) {
        this.creator = new ShipCreator(shipGateway, idGenerator);
        this.finder = new ShipFinder(shipGateway);
        this.remover = new ShipRemover(shipGateway);
    }

    public Either<Error, CreateOutputData> create(ShipCreateInputData inputData) {
        return creator.create(inputData);
    }

    public Either<Error, ShipOutputData> findById(String id) {
        return finder.findById(id);
    }

    public void remove(String shipId) {
        remover.remove(shipId);
    }
}
