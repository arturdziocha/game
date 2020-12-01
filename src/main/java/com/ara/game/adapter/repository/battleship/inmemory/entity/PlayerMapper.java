package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.player.dto.PlayerDTO;

public class PlayerMapper {
    public PlayerInMemory mapToEntity(PlayerDTO player) {
        return PlayerInMemory
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }

    public PlayerDTO mapToOutputData(PlayerInMemory player) {
        return PlayerDTO
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }
}
