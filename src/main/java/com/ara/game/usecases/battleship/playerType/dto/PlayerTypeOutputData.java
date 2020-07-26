package com.ara.game.usecases.battleship.playerType.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class PlayerTypeOutputData {
    @Getter
    private final String id;
    @Getter
    private final String name;
}
