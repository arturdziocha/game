package com.ara.game.usecases.battleship.game.port;

import com.ara.game.usecases.battleship.game.dto.GameDTO;

import io.vavr.control.Option;

public interface GameGateway {
    public GameDTO create(GameDTO inputData);

    public Option<GameDTO> find(String id);
}
