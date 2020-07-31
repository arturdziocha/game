package com.ara.game.usecases.battleship.shipPoints;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;

final class ShipPointsValidator {
    Option<Error> validateAll(ShipPointsCreateInputData inputData) {
        if (inputData == null) {
            return Option.some(ShipPointsError.DATA_CANNOT_BE_NULL);
        }
        if (StringUtils.isEmpty(inputData.getShipId()) || inputData.getPoints().isEmpty()) {
            return Option.some(ShipPointsError.DATA_CANNOT_BE_NULL);
        }
        return Option.none();
    }
}
