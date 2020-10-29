package com.ara.game.usecases.battleship.shipPoints.dto;

import io.vavr.collection.Seq;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public final class ShipPointsCreateInputData {
    @Getter
    private final String shipId;
    @Getter
    private final Seq<String> points;
}
