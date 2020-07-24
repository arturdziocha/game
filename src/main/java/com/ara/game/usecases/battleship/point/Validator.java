package com.ara.game.usecases.battleship.point;

import org.apache.commons.lang3.StringUtils;

import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointCreateStringInputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Option;

final class Validator {
    final Option<Error> validateRowCol(PointCreateRowColInputData inputData) {
        if (inputData == null) {
            return Option.some(PointError.DATA_CANNOT_BE_NULL);
        }
        if (inputData.getRow() == null) {
            return Option.some(PointError.ROW_CANNOT_BE_NULL);
        }
        if (Integer.signum(inputData.getRow()) < 0) {
            return Option.some(PointError.ROW_CANNOT_BE_NEGATIVE);
        }
        if (inputData.getColumn() == null) {
            return Option.some(PointError.COLUMN_CANNOT_BE_NULL);
        }
        if (Integer.signum(inputData.getColumn()) < 0) {
            return Option.some(PointError.COLUMN_CANNOT_BE_NEGATIVE);
        }
        return Option.none();
    }

    final Option<Error> validatePointString(PointCreateStringInputData inputData) {
        if (inputData == null) {
            return Option.some(PointError.DATA_CANNOT_BE_NULL);
        }
        if (StringUtils.isEmpty(inputData.getPointString())) {
            return Option.some(PointError.POINT_STRING_CANNOT_BE_EMPTY);
        }
        return Option.none();
    }
}