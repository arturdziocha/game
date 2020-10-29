package com.ara.game.usecases.battleship.shipclass;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Either;

final class ShipClassFinder {
    private final ShipClassMapper mapper;

    ShipClassFinder(ShipClassMapper mapper) {
        this.mapper = mapper;
    }

    Either<Error, ShipClassOutputData> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Either.left(ShipClassError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(ShipClass.values())
                .find(sC -> sC.getName().equals(name))
                .map(mapper::mapToOutputData)
                .toEither(ShipClassError.SHIP_CLASS_NOT_FOUND);
    }

    Either<Error, ShipClassOutputData> findByShortName(String shortName) {
        if (StringUtils.isEmpty(shortName)) {
            return Either.left(ShipClassError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(ShipClass.values())
                .find(sC -> sC.getShortName().equals(shortName))
                .map(mapper::mapToOutputData)
                .toEither(ShipClassError.SHIP_CLASS_NOT_FOUND);
    }

    Seq<ShipClassOutputData> findAll() {
        return Stream.of(ShipClass.values()).map(mapper::mapToOutputData);
    }

}
