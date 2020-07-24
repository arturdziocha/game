package com.ara.game.usecases.battleship.direction.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public final class DirectionOutputData {
    @Getter
    private final String name;
    @Getter
    private final String shortName;
}