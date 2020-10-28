package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.adapter.repository.battleship.inmemory.EntityInMemory;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class PointInMemory extends EntityInMemory {
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
