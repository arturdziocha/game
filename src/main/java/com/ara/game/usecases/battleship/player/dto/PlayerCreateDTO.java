package com.ara.game.usecases.battleship.player.dto;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PlayerCreateDTO {
    @Getter
    private final String name;
    @Getter
    private final PlayerTypeDTO playerType;
}
