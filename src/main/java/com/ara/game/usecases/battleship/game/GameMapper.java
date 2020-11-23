package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameDTO;

final class GameMapper {
    GameDTO mapToDTO(Game game) {
        return GameDTO.builder().id(game.getId()).boardSize(game.getBoardSize()).build();
    }
}
