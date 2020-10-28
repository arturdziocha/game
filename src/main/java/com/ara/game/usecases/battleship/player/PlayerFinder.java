package com.ara.game.usecases.battleship.player;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;
final class PlayerFinder {
    private final PlayerGateway playerGateway;

    PlayerFinder(final PlayerGateway playerGateway) {
        this.playerGateway = playerGateway;
    }
    final Either<Error, PlayerOutputData> find(String id) {
        if (StringUtils.isEmpty(id)) {
            return Either.left(PlayerError.DATA_CANNOT_BE_EMPTY);
        }
        return playerGateway.findById(id).toEither(PlayerError.CANNOT_FIND_PLAYER);
    }
}
