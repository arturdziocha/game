package com.ara.game.usecases.battleship.gamePlayers;

import com.ara.game.usecases.battleship.gamePlayers.dto.GamePLayersJoinDTO;
import com.ara.game.usecases.battleship.gamePlayers.dto.GamePlayersDTO;

import io.vavr.control.Option;

public interface GamePlayersGateway {
    Option<GamePlayersDTO> find(String gameId);

    GamePlayersDTO join(GamePLayersJoinDTO inputData);

    boolean isTwoPlayersSet(String gameId);
}
