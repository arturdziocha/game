package com.ara.game.usecases.battleship.point;

import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointsCreateInputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Either;

final class PointsCreator {
    private final PointFinder finder;
    private final PointCreator creator;

    PointsCreator(final PointFinder finder, final PointCreator creator) {
        this.finder = finder;
        this.creator = creator;
    }

    final Either<Error, Seq<CreateOutputData>> create(PointsCreateInputData inputData) {
        return fill(inputData);
    }

    final Either<Error, Seq<CreateOutputData>> createRandom(PointsCreateInputData inputData) {

        Either<Error, Seq<CreateOutputData>> chooser = fill(inputData);
        while (chooser.isLeft()) {
            chooser = fill(inputData);
        }
        return chooser;
    }

    private Either<Error, Seq<CreateOutputData>> fill(PointsCreateInputData pointsCreateInputData) {
        Seq<CreateOutputData> points = List.empty();
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
            Either<Error, CreateOutputData> created = finder
                    .findByRowAndColumn(row, column)
                    .map(p -> CreateOutputData.builder().id(p.getId()).build())
                    .orElse(create(row, column));
            if (created.isLeft()) {
                return Either.left(created.getLeft());
            }
            points = points.append(created.get());
        }
        return Either.right(points);
    }

    private Either<Error, CreateOutputData> create(Integer row, Integer column) {
        return creator.create(PointCreateRowColInputData.builder().row(row).column(column).build());
    }
}