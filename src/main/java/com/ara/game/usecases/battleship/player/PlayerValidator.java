package com.ara.game.usecases.battleship.player;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.player.dto.PlayerCreateDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;

final class PlayerValidator {
    final Option<Error> validate(PlayerCreateDTO inputData) {
        if (inputData == null) {
            return Option.some(PlayerError.DATA_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getName())) {
            return Option.some(PlayerError.PLAYER_NAME_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getPlayerType().getId())) {
            return Option.some(PlayerError.PLAYER_TYPE_CANNOT_BE_EMPTY);
        }
        return Option.none();
    }
}
