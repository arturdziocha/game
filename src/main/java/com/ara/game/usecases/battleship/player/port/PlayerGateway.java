package com.ara.game.usecases.battleship.player.port;

import com.ara.game.usecases.battleship.player.dto.PlayerAllDataDTO;
import com.ara.game.usecases.battleship.player.dto.PlayerDTO;

import io.vavr.control.Option;

public interface PlayerGateway {
    Option<PlayerDTO> findById(String id);

    Option<PlayerAllDataDTO> findAllData(String id);

    PlayerDTO save(PlayerDTO inputData);

}
