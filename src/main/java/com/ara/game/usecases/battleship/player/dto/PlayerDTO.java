package com.ara.game.usecases.battleship.player.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PlayerDTO {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final String playerTypeId;
}
