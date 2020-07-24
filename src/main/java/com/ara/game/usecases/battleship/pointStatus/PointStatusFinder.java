package com.ara.game.usecases.battleship.pointStatus;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.pointStatus.dto.PointStatusOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Stream;
import io.vavr.control.Either;

final class PointStatusFinder {
    private final PointStatusMapper mapper;

    PointStatusFinder(final PointStatusMapper mapper) {
        this.mapper = mapper;
    }

    final Either<Error, PointStatusOutputData> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Either.left(PointStatusError.NAME_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(PointStatus.values())
                .find(pS -> pS.getName().equals(name))
                .map(mapper::mapToOutputData)
                .toEither(PointStatusError.CANNOT_FIND_POINT_STATUS);
    }

}
