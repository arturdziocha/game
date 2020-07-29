package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.battleship.ship.dtos.ShipCreateInputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;

import io.vavr.control.Either;
import io.vavr.control.Option;

final class ShipCreator {
    private final ShipGateway shipGateway;
    private final IdGenerator idGenerator;
    private final ShipClassFacade shipClassFacade;
    private final Validator validator;
    private final ShipMapper mapper;
    
    ShipCreator(ShipGateway shipGateway, IdGenerator idGenerator) {
        this.shipGateway = shipGateway;
        this.idGenerator = idGenerator;
        this.shipClassFacade = new ShipClassFacade();
        this.validator = new Validator();
        this.mapper = new ShipMapper();
    }

    Either<Error, CreateOutputData> create(ShipCreateInputData inputData) {
        Option<Error> validation = validator.validate(inputData);
        if (validation.isDefined()) {
            return Either.left(validation.get());
        }
        Either<Error, ShipClassOutputData> shipClass = shipClassFacade
                .findByShortName(inputData.getShipClassShortName());
        if (shipClass.isLeft()) {
            return Either.left(shipClass.getLeft());
        }
        Ship ship = Ship
                .builder()
                .id(idGenerator.generate())
                .shipClassShortName(inputData.getShipClassShortName())
                .health(shipClass.get().getSize())
                .build();
        return Either.right(mapper.mapToCreateOutputData(shipGateway.save(mapper.mapToOutputData(ship))));

    }
}
