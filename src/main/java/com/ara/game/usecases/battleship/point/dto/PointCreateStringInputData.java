package com.ara.game.usecases.battleship.point.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PointCreateStringInputData {
    @Getter
    private final String pointString;
}