package com.ara.game.usecases.battleship.playerShip;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
final class PlayerShip {
    @Getter
    @NonNull
    private final String playerId;
    @Getter
    @NonNull
    private final String shipId;
}
