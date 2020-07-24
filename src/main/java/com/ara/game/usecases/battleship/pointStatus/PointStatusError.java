package com.ara.game.usecases.battleship.pointStatus;

import com.ara.game.usecases.common.Error;

enum PointStatusError implements Error {
    CANNOT_FIND_POINT_STATUS("Cannot find point status"),
    NAME_CANNOT_BE_EMPTY("Name cannot be empty");

    private final String cause;

    PointStatusError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
