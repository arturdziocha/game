package com.ara.game.usecases.battleship.point;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.port.PointGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

final class PointFinder {
    private final PointGateway pointGateway;

    PointFinder(final PointGateway pointGateway) {
        this.pointGateway = pointGateway;
    }

    final Either<Error, PointOutputData> findById(final String id) {
        if (StringUtils.isEmpty(id)) {
            return Either.left(PointError.POINT_ID_CANNOT_BE_EMPTY);
        } else {
            return pointGateway.findById(id).toEither(PointError.CANNOT_FIND_POINT);
        }

    }

    final Either<Error, PointOutputData> findByRowAndColumn(Integer row, Integer column) {
        if (row == null || column == null) {
            return Either.left(PointError.DATA_CANNOT_BE_NULL);
        }
        return pointGateway.findByRowAndColumn(row, column).toEither(PointError.CANNOT_FIND_POINT);
    }

    final Either<Error, PointOutputData> findByPointString(String pointString) {
        if (StringUtils.isEmpty(pointString)) {
            return Either.left(PointError.DATA_CANNOT_BE_NULL);
        }
        return pointGateway.findByPointString(pointString.toUpperCase()).toEither(PointError.CANNOT_FIND_POINT);
    }

}
