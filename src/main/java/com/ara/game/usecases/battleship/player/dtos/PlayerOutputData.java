package com.ara.game.usecases.battleship.player.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class PlayerOutputData {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final String playerTypeId;
}
