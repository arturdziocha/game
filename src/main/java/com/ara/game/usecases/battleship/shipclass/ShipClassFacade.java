package com.ara.game.usecases.battleship.shipclass;

import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.control.Either;

public final class ShipClassFacade {
    private final ShipClassFinder finder;

    public ShipClassFacade() {
        ShipClassMapper mapper = new ShipClassMapper();
        this.finder = new ShipClassFinder(mapper);

    }

    public Either<Error, ShipClassOutputData> findByName(String name) {
        return finder.findByName(name);
    }

    public Either<Error, ShipClassOutputData> findByShortName(String shortName) {
        return finder.findByShortName(shortName);
    }

    public Seq<ShipClassOutputData> findAll() {
        return finder.findAll();
    }
}