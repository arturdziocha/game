package com.ara.game.adapter.repository.battleship.inmemory;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EntityInMemory {
    @NonNull
    private final String id;
}