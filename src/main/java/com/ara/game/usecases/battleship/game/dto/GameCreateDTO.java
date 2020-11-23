package com.ara.game.usecases.battleship.game.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
public final class GameCreateDTO {
    @Getter
    @NonNull
    private final Short boardSize;
}
