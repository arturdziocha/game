package com.ara.game.usecases.battleship.direction;

import java.util.List;

import com.ara.game.usecases.battleship.direction.dto.DirectionOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

public final class DirectionFacade {
    private final DirectionFinder finder;

    public DirectionFacade() {
        DirectionMapper mapper = new DirectionMapper();
        this.finder = new DirectionFinder(mapper);
    }

    public final Either<Error, DirectionOutputData> findByName(String name) {
        return finder.findByName(name);
    }

    public final Either<Error, DirectionOutputData> findByShortName(String shortName) {
        return finder.findByShortName(shortName);
    }

    public final List<DirectionOutputData> findAll() {
        return finder.findAll();
    }

    public final DirectionOutputData findRandom() {
        return finder.findRandom();
    }

}