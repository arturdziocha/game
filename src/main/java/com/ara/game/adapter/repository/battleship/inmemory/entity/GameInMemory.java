package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.adapter.repository.battleship.inmemory.EntityInMemory;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

@SuperBuilder
public class GameInMemory extends EntityInMemory {
    @Getter
    @NonNull
    private final String id;
    @Getter
    @NonNull
    private final Short boardSize;
}
