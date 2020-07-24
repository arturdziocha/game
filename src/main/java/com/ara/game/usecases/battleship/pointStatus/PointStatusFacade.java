package com.ara.game.usecases.battleship.pointStatus;

import com.ara.game.usecases.battleship.pointStatus.dto.PointStatusOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

public final class PointStatusFacade {
    private final PointStatusFinder finder;

    public PointStatusFacade() {
        PointStatusMapper mapper = new PointStatusMapper();
        this.finder = new PointStatusFinder(mapper);
    }

    public Either<Error, PointStatusOutputData> findByName(String name) {
        return finder.findByName(name);
    }
}
