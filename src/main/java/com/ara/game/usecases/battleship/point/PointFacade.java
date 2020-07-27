package com.ara.game.usecases.battleship.point;

import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointCreateStringInputData;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.dto.PointsCreateInputData;
import com.ara.game.usecases.battleship.point.port.PointGateway;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;
import com.google.inject.Inject;

import io.vavr.control.Either;

public final class PointFacade {
    private final PointCreator pointCreator;
    private final PointsCreator pointsCreator;
    private final PointFinder finder;

    @Inject
    public PointFacade(PointGateway pointGateway, IdGenerator idGenerator) {
        PointMapper mapper = new PointMapper();
        pointCreator = new PointCreator(pointGateway, idGenerator, mapper);
        finder = new PointFinder(pointGateway);
        pointsCreator = new PointsCreator(finder, pointCreator);
    }

    public final Either<Error, CreateOutputData> create(PointCreateStringInputData inputData) {
        return pointCreator.create(inputData);
    }

    public final Either<Error, CreateOutputData> create(PointCreateRowColInputData inputData) {
        return pointCreator.create(inputData);
    }

    public Either<Error, List<CreateOutputData>> createPoints(PointsCreateInputData inputData) {
        return pointsCreator.create(inputData);
    }

    public Either<Error, List<CreateOutputData>> createRandomPoints(PointsCreateInputData inputData) {
        return pointsCreator.createRandom(inputData);
    }

    public final Either<Error, PointOutputData> findById(String id) {
        return finder.findById(id);
    }

    public final Either<Error, PointOutputData> findByRowAndColumn(Integer row, Integer column) {
        return finder.findByRowAndColumn(row, column);
    }

    public final Either<Error, PointOutputData> findByPointString(String pointString) {
        return finder.findByPointString(pointString);
    }
}