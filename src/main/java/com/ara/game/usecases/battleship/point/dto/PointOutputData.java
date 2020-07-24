package com.ara.game.usecases.battleship.point.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@ToString
public final class PointOutputData {
    @Getter
    private final String id;
    @Getter
    private final String pointString;
    @Getter
    private final Integer row;
    @Getter
    private final Integer column;
}
