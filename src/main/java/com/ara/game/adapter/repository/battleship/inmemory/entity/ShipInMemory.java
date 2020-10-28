package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.adapter.repository.battleship.inmemory.EntityInMemory;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ShipInMemory extends EntityInMemory {
    @Getter
    @NonNull
    private final String shipClassShortName;
    @Getter
    @NonNull
    private final Integer health;
}
