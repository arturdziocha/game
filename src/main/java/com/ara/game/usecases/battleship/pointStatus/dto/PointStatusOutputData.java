package com.ara.game.usecases.battleship.pointStatus.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public final class PointStatusOutputData {
    @Getter
    private final String name;
    @Getter
    private final String status;
}
