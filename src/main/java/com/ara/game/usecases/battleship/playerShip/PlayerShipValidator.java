package com.ara.game.usecases.battleship.playerShip;
import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipCreateDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;
final class PlayerShipValidator {
    final Option<Error> validate(PlayerShipCreateDTO inputData) {
        if (inputData == null) {
            return Option.some(PlayerShipError.DATA_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getPlayerId())) {
            return Option.some(PlayerShipError.PLAYER_ID_CANNOT_BE_EMPTY);
        }
        if (StringUtils.isEmpty(inputData.getShipId())) {
            return Option.some(PlayerShipError.SHIP_ID_CANNOT_BE_EMPTY);
        }
        return Option.none();
    }
}
