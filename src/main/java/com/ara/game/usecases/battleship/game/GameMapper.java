package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameDTO;

final class GameMapper {
    GameDTO mapToDTO(Game game) {
        return GameDTO.builder().playerId(game.getPlayerId()).id(game.getId()).boardSize(game.getBoardSize()).build();
    }
}
