package com.ara.game.usecases.battleship.shipclass.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
public final class ShipClassOutputData {
    @Getter
    private final String name;
    @Getter
    private final String shortName;
    @Getter
    private final Integer size;
}
