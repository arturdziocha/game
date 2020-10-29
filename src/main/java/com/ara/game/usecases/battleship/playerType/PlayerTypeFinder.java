package com.ara.game.usecases.battleship.playerType;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Either;

class PlayerTypeFinder {
    private final PlayerTypeMapper mapper;

    public PlayerTypeFinder(final PlayerTypeMapper mapper) {
        this.mapper = mapper;
    }

    final Either<Error, PlayerTypeOutputData> findById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Either.left(PlayerTypeError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(PlayerType.values())
                .find(pT -> pT.getId().equals(id))
                .map(mapper::mapToOutputData)
                .toEither(PlayerTypeError.CANNOT_FIND_TYPE_OF_PLAYER);
    }

    final Either<Error, PlayerTypeOutputData> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Either.left(PlayerTypeError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(PlayerType.values())
                .find(pT -> pT.getName().equals(name))
                .map(mapper::mapToOutputData)
                .toEither(PlayerTypeError.CANNOT_FIND_TYPE_OF_PLAYER);
    }

    final Seq<PlayerTypeOutputData> findAll() {
        return Stream.of(PlayerType.values()).map(mapper::mapToOutputData);
    }
}