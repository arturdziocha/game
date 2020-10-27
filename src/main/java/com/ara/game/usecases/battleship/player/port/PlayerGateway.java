package com.ara.game.usecases.battleship.player.port;

import com.ara.game.usecases.battleship.player.dtos.PlayerOutputAllData;
import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;

import io.vavr.control.Option;

public interface PlayerGateway {
    Option<PlayerOutputData> findById(String id);

    Option<PlayerOutputAllData> findAllData(String id);

    PlayerOutputData save(PlayerOutputData inputData);

}
