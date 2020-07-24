package com.ara.game.usecases.battleship.shipclass;

import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;

final class ShipClassMapper {
    ShipClassOutputData mapToOutputData(ShipClass shipClass) {
        return ShipClassOutputData
                .builder()
                .name(shipClass.getName())
                .shortName(shipClass.getShortName())
                .size(shipClass.getSize())
                .build();
    }
}
