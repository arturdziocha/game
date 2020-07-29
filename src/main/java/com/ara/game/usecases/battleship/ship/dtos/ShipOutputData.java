package com.ara.game.usecases.battleship.ship.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public final class ShipOutputData {
    @Getter
    private final String id;
    @Getter
    private final String shipClassShortName;
    @Getter
    private final Integer health;
}
