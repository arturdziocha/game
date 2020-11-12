package com.ara.game.usecases.battleship.shot.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ShotCreateInputData {
    @Getter
    private final String playerId;
    @Getter
    private final String pointId;
}
