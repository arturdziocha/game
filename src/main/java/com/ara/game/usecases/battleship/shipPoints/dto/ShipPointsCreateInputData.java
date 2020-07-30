package com.ara.game.usecases.battleship.shipPoints.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class ShipPointsCreateInputData {
    @Getter
    private final String shipId;
    @Getter
    private final List<String> points;
}
