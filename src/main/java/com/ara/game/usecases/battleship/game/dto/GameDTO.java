package com.ara.game.usecases.battleship.game.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class GameDTO {
    @Getter
    private final String id;
    @Getter
    private final Short boardSize;
}
