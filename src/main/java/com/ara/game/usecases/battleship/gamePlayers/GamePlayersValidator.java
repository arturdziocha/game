package com.ara.game.usecases.battleship.gamePlayers;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.gamePlayers.dto.GamePLayersJoinDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;

final class GamePlayersValidator {
    Option<Error> validate(GamePLayersJoinDTO inputData) {
        if (inputData == null) {
            return Option.some(GamePlayersError.DATA_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getGameId())) {
            return Option.some(GamePlayersError.DATA_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getPlayerId())) {
            return Option.some(GamePlayersError.DATA_CANNOT_BE_EMPTY);
        }

        return Option.none();
    }
}
