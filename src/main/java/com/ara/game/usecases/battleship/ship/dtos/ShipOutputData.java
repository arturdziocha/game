package com.ara.game.usecases.battleship.ship.dtos;

import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public final class ShipOutputData {
    @Getter
    private final String id;
    @Getter
    private final ShipClassOutputData shipClass;
    @Getter
    private final Integer health;
}
