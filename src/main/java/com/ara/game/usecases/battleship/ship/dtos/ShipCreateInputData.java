package com.ara.game.usecases.battleship.ship.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class ShipCreateInputData {
    @Getter
    private final String shipClassShortName;
}
