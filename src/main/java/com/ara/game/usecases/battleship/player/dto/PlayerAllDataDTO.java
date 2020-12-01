package com.ara.game.usecases.battleship.player.dto;

import java.util.List;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;

import lombok.Builder;
import lombok.Getter;

@Builder
public class PlayerAllDataDTO {
    @Getter
    private final String id;
    @Getter
    private final String name;
    @Getter
    private final PlayerTypeDTO playerType;
    @Getter
    private final List<ShipOutputData> ships;
}
