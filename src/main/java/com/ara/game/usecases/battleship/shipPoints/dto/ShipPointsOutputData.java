package com.ara.game.usecases.battleship.shipPoints.dto;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;

import io.vavr.collection.Seq;
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
    private final Seq<PointOutputData> shipPoints;
}
