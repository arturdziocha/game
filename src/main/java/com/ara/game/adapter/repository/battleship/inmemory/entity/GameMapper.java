package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.game.dto.GameDTO;

public class GameMapper {
    public GameDTO mapToDTO(GameInMemory game) {
        return GameDTO.builder().id(game.getId()).boardSize(game.getBoardSize()).build();
    }

    public GameInMemory mapToEntity(GameDTO game) {
        return GameInMemory.builder().id(game.getId()).boardSize(game.getBoardSize()).build();
    }
}
