package com.ara.game.usecases.battleship.player.dtos;

import java.util.List;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;

import lombok.Builder;
import lombok.Getter;

@Builder
public class PlayerOutputAllData {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final PlayerTypeOutputData playerType;
    @Getter
    private final List<ShipOutputData> ships;
}
