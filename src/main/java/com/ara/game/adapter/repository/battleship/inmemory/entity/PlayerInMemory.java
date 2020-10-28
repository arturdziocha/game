package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.adapter.repository.battleship.inmemory.EntityInMemory;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
@SuperBuilder
public class PlayerInMemory extends EntityInMemory{
    @Getter
    @NonNull
    private final String name;
    @Getter
    @NonNull
    private final String playerTypeId;
}
