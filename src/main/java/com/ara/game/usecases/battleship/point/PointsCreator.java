package com.ara.game.usecases.battleship.point;

import java.util.ArrayList;
import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.dto.PointsCreateInputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

final class PointsCreator {
    private final PointFinder finder;
    private final PointCreator creator;

    PointsCreator(final PointFinder finder, final PointCreator creator) {
        this.finder = finder;
        this.creator = creator;
    }

    final Either<Error, List<CreateOutputData>> create(PointsCreateInputData inputData) {
        return fill(inputData);
    }

    final Either<Error, List<CreateOutputData>> createRandom(PointsCreateInputData inputData) {

        Either<Error, List<CreateOutputData>> chooser = fill(inputData);
        while (chooser.isLeft()) {
            chooser = fill(inputData);
        }
        return chooser;
    }

    private Either<Error, List<CreateOutputData>> fill(PointsCreateInputData pointsCreateInputData) {
        List<CreateOutputData> points = new ArrayList<>();
        for (int i = 0; i < pointsCreateInputData.getSize(); i++) {
            int row = 0;
            int column = 0;
            switch (pointsCreateInputData.getDirectionShortName()) {
                case "u":
                    row = pointsCreateInputData.getPoint().getRow() - 1;
                    column = pointsCreateInputData.getPoint().getColumn();
                    break;
                case "r":
                    row = pointsCreateInputData.getPoint().getRow();
                    column = pointsCreateInputData.getPoint().getColumn() + i;
                    break;
                case "d":
                    row = pointsCreateInputData.getPoint().getRow() + i;
                    column = pointsCreateInputData.getPoint().getColumn();
                    break;
                case "l":
                    row = pointsCreateInputData.getPoint().getRow();
                    column = pointsCreateInputData.getPoint().getColumn() - i;
                    default:
                        return Either.left(PointError.CANNOT_CREATE_POINTS);
            }
            Either<Error, PointOutputData> findPoint = finder.findByRowAndColumn(row, column);
            Either<Error, CreateOutputData> created = findPoint
                    .map(p -> CreateOutputData.builder().id(p.getId()).build())
                    .orElse(create(row, column));
            if (created.isLeft()) {
                return Either.left(created.getLeft());
            }

            points.add(created.get());
        }
        return Either.right(points);
    }

    private Either<Error, CreateOutputData> create(Integer row, Integer column) {
        return creator.create(PointCreateRowColInputData.builder().row(row).column(column).build());
    }
}