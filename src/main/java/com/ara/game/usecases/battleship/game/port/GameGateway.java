package com.ara.game.usecases.battleship.game.port;

import com.ara.game.usecases.battleship.game.dto.GameDTO;

public interface GameGateway {
    public GameDTO create(GameDTO inputData);
}
