package com.ara.game.usecases.battleship.shipPoints.dto;

import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;

import lombok.Builder;

@Builder
public final class ShipPointsOutputData {
    private final String shipId;
    private final List<PointOutputData> shipPoints;
}
