package com.ara.game.usecases.battleship.ship;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.ship.dtos.ShipCreateInputData;
import com.ara.game.usecases.common.Error;
import io.vavr.control.Option;

class Validator {
    Option<Error> validate(ShipCreateInputData inputData) {
        if(inputData == null) {
            return Option.some(ShipError.DATA_CANNOT_BE_NULL);
        }
        if (StringUtils.isEmpty(inputData.getShipClassShortName())) {
            return Option.some(ShipError.SHIP_CLASS_CANNOT_BE_EMPTY);
        }
        return Option.none();
    }
}
