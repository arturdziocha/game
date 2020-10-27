package com.ara.game.usecases.battleship.player;

import com.ara.game.usecases.common.domain.Entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
final class Player extends Entity {
    @Getter
    @NonNull
    private final String name;
    @Getter
    @NonNull
    private final String playerTypeId;
}
