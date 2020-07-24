package com.ara.game.usecases.common.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
public class Entity {
    @Getter
    @NonNull
    private final String id;
}