package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.CreateOutputData;

final class ShipMapper {
    final CreateOutputData mapToCreateOutputData(ShipOutputData ship) {
        return CreateOutputData.builder().id(ship.getId()).build();
    }

    final ShipOutputData mapToDTO(Ship ship, ShipClassOutputData shipClass) {
        return ShipOutputData
                .builder()
                .id(ship.getId())
                .shipClass(shipClass)
                .health(ship.getHealth())
                .build();
    }
}
