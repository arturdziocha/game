package com.ara.game.usecases.battleship.direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.direction.dto.DirectionOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Stream;
import io.vavr.control.Either;

final class DirectionFinder {
    private final DirectionMapper mapper;

    DirectionFinder(DirectionMapper mapper) {
        this.mapper = mapper;
    }

    final Either<Error, DirectionOutputData> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Either.left(DirectionError.VALUE_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(Direction.values())
                .find(direction -> direction.getName().equals(name))
                .map(mapper::mapToOutputData)
                .toEither(DirectionError.CANNOT_FIND_DIRECTION);
    }

    final Either<Error, DirectionOutputData> findByShortName(String shortName) {
        if (StringUtils.isEmpty(shortName)) {
            return Either.left(DirectionError.VALUE_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(Direction.values())
                .find(direction -> direction.getShortName().equals(shortName))
                .map(mapper::mapToOutputData)
                .toEither(DirectionError.CANNOT_FIND_DIRECTION);
    }

    final List<DirectionOutputData> findAll() {
        return Arrays.stream(Direction.values()).map(mapper::mapToOutputData).collect(Collectors.toList());
    }

    final DirectionOutputData findRandom() {
        List<DirectionOutputData> all = findAll();
        return all.get(new Random().nextInt(all.size()));
    }

}
