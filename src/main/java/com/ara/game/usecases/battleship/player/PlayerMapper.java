package com.ara.game.usecases.battleship.player;

import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.common.CreateOutputData;

final class PlayerMapper {
    final PlayerDTO mapToPlayerDTO(Player player) {
        return PlayerDTO
                .builder()
                .id(player.getId())
                .name(player.getName())
                .playerTypeId(player.getPlayerTypeId())
                .build();
    }

    final CreateOutputData mapToCreateOutput(PlayerDTO dto) {
        return CreateOutputData.builder().id(dto.getId()).build();
    }
}
