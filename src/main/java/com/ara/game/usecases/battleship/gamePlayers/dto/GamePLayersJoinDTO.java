package com.ara.game.usecases.battleship.gamePlayers.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class GamePLayersJoinDTO {
    @Getter
    private final String gameId;
    @Getter
    private final String playerId;
}
