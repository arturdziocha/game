package com.ara.game.usecases.battleship.shipPoints.dto;

import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
public final class ShipPointsOutputData {
    @Getter
    @NonNull
    private final String shipId;
    @Getter
    @NonNull
    private final List<PointOutputData> shipPoints;
}
