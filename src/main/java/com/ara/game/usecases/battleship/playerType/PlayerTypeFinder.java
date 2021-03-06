package com.ara.game.usecases.battleship.playerType;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.collection.Stream;
import io.vavr.control.Either;

class PlayerTypeFinder {
    private final PlayerTypeMapper mapper;

    public PlayerTypeFinder(final PlayerTypeMapper mapper) {
        this.mapper = mapper;
    }

    final Either<Error, PlayerTypeDTO> findById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Either.left(PlayerTypeError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(PlayerType.values())
                .find(pT -> pT.getId().equals(id))
                .map(mapper::mapToDTO)
                .toEither(PlayerTypeError.CANNOT_FIND_TYPE_OF_PLAYER);
    }

    final Either<Error, PlayerTypeDTO> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Either.left(PlayerTypeError.DATA_CANNOT_BE_EMPTY);
        }
        return Stream
                .of(PlayerType.values())
                .find(pT -> pT.getName().equals(name))
                .map(mapper::mapToDTO)
                .toEither(PlayerTypeError.CANNOT_FIND_TYPE_OF_PLAYER);
    }

    final Seq<PlayerTypeDTO> findAll() {
        return Stream.of(PlayerType.values()).map(mapper::mapToDTO);
    }
}