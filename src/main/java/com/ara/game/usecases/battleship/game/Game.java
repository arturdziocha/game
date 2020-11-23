package com.ara.game.usecases.battleship.game;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
final class Game {
    @Getter
    @NonNull
    private final String id;
    @Getter
    @NonNull
    private final Short boardSize;
}