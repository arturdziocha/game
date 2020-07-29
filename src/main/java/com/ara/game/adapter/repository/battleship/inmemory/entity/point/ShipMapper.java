package com.ara.game.adapter.repository.battleship.inmemory.entity.point;

import com.ara.game.usecases.battleship.ship.dtos.ShipOutputData;

public class ShipMapper {
    public ShipInMemory mapToEntity(ShipOutputData ship) {
        return ShipInMemory
                .builder()
                .id(ship.getId())
                .shipClassShortName(ship.getShipClassShortName())
                .health(ship.getHealth())
                .build();
    }

    public ShipOutputData mapToOutputData(ShipInMemory ship) {
        return ShipOutputData
                .builder()
                .id(ship.getId())
                .shipClassShortName(ship.getShipClassShortName())
                .health(ship.getHealth())
                .build();
    }
}
