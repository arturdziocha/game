package com.ara.game.usecases.battleship.playerType;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeOutputData;

final class PlayerTypeMapper {
    final PlayerTypeOutputData mapToDTO(PlayerType playerType) {
        return PlayerTypeOutputData.builder().id(playerType.getId()).name(playerType.getName()).build();
    }
}