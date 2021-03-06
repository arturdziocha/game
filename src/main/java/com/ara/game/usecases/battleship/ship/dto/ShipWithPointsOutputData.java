package com.ara.game.usecases.battleship.ship.dto;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;

import io.vavr.collection.Seq;
import lombok.Builder;
import lombok.Getter;

@Builder
public final class ShipWithPointsOutputData {
    @Getter
    private final String id;
    @Getter
    private final ShipClassOutputData shipClass;
    @Getter
    private final Integer health;
    @Getter
    private final Seq<PointOutputData> points;
}
