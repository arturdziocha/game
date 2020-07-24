package com.ara.game.usecases.battleship.point;

import com.ara.game.usecases.common.domain.Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
final class Point extends Entity {
    @Getter
    @NonNull
    private final Integer row;

    @Getter
    @NonNull
    private final Integer column;

    @Getter
    @NonNull
    private final String pointString;
}
