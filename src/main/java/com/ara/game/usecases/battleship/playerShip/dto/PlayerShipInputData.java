package com.ara.game.usecases.battleship.playerShip.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PlayerShipInputData {
    @Getter
    private final String playerId;
    @Getter
    private final String shipId;
}
