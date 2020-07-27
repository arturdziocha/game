package com.ara.game.usecases.battleship.point.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PointsCreateInputData {
    @Getter
    private final Integer size;
    @Getter
    private final PointOutputData point;
    @Getter
    private final String directionShortName;

}
