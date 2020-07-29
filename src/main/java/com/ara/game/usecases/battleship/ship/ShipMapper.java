package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;
import com.ara.game.usecases.common.CreateOutputData;

final class ShipMapper {
    final CreateOutputData mapToCreateOutputData(ShipOutputData ship) {
        return CreateOutputData.builder().id(ship.getId()).build();
    }

    final ShipOutputData mapToOutputData(Ship ship) {
        return ShipOutputData
                .builder()
                .id(ship.getId())
                .shipClassShortName(ship.getShipClassShortName())
                .health(ship.getHealth())
                .build();
    }
}