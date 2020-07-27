package com.ara.game.usecases.battleship.point;

import com.ara.game.usecases.common.Error;

enum PointError implements Error {
    POINT_ID_CANNOT_BE_EMPTY("Point id cannot be empty"),
    POINT_STRING_CANNOT_BE_EMPTY("Point string cannot be empty"),
    ROW_CANNOT_BE_NULL("Row cannot be null"),
    ROW_CANNOT_BE_NEGATIVE("Row cannot be negative"),
    COLUMN_CANNOT_BE_NULL("Column cannot be null"),
    COLUMN_CANNOT_BE_NEGATIVE("Column cannot be negative"),
    CANNOT_PARSE_STRING("Point string cannot be parsed"),
    WRONG_COLUMN_SPECIFIED("Wrong column specified"),
    CANNOT_FIND_POINT("Cannot find point in database"),
    PERSISTENCE_FAILED("Persistence failed"),
    CANNOT_FIND_ALL_POINTS("Cannot find all points"),
    DATA_CANNOT_BE_NULL("Data cannot be null"),
    CANNOT_CREATE_POINTS("Points cannot be crated");

    private final String cause;

    PointError(final String cause) {
        this.cause = cause;
    }

    @Override
    public String getCause() {
        return cause;
    }

}