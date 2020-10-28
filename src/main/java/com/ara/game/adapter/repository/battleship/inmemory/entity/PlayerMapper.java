package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;

public class PlayerMapper {
    public PlayerInMemory mapToEntity(PlayerOutputData player) {
        return PlayerInMemory
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }

    public PlayerOutputData mapToOutputData(PlayerInMemory player) {
        return PlayerOutputData
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }
}
