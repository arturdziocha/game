package com.ara.game.usecases.battleship.point.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PointCreateRowColInputData {
    @Getter
    private final Integer row;
    @Getter
    private final Integer column;
}
