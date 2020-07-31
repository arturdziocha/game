package com.ara.game.usecases.battleship.shipPoints;

import com.ara.game.usecases.common.Error;

enum ShipPointsError implements Error {
    DATA_CANNOT_BE_NULL("DATA CANNOT BE NULL"),
    CANNOT_FIND_RELATED_POINTS("Cannot find ship points");
    private final String cause;

    ShipPointsError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }
}
