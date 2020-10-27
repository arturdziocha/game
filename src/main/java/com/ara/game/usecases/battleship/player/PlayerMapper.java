package com.ara.game.usecases.battleship.player;

import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;
import com.ara.game.usecases.common.CreateOutputData;

final class PlayerMapper {
    final PlayerOutputData mapToPlayerDTO(Player player) {
        return PlayerOutputData
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }

    final CreateOutputData mapToCreateOutput(PlayerOutputData dto) {
        return CreateOutputData.builder().id(dto.getId()).build();
    }
}
