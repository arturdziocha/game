package com.ara.game.usecases.battleship.playerType;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;

final class PlayerTypeMapper {
    final PlayerTypeDTO mapToDTO(PlayerType playerType) {
        return PlayerTypeDTO.builder().id(playerType.getId()).name(playerType.getName()).build();
    }
}