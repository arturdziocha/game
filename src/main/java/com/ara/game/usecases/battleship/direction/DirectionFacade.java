package com.ara.game.usecases.battleship.direction;

import com.ara.game.usecases.battleship.direction.dto.DirectionDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.control.Either;

public final class DirectionFacade {
    private final DirectionFinder finder;

    public DirectionFacade() {
        DirectionMapper mapper = new DirectionMapper();
        this.finder = new DirectionFinder(mapper);
    }

    public final Either<Error, DirectionDTO> findByName(String name) {
        return finder.findByName(name);
    }

    public final Either<Error, DirectionDTO> findByShortName(String shortName) {
        return finder.findByShortName(shortName);
    }

    public final Seq<DirectionDTO> findAll() {
        return finder.findAll();
    }

    public final DirectionDTO findRandom() {
        return finder.findRandom();
    }

}