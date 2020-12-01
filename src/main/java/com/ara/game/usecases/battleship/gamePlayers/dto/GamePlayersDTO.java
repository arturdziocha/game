package com.ara.game.usecases.battleship.gamePlayers.dto;

import com.ara.game.usecases.battleship.player.dto.PlayerDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class GamePlayersDTO {
    @Getter
    private final String gameId;
    @Getter
    private final PlayerDTO firstPlayerId;
    @Getter
    private final PlayerDTO secondPlayerId;
    @Getter
    private final PlayerDTO currentPlayerId;
}
