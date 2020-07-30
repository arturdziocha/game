package com.ara.game.adapter.repository.battleship.inmemory.entity.point;

import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;

public class ShipMapper {
    public ShipInMemory mapToEntity(ShipOutputData ship) {
        return ShipInMemory
                .builder()
                .id(ship.getId())
                .shipClassShortName(ship.getShipClass().getShortName())
                .health(ship.getHealth())
                .build();
    }

    public ShipOutputData mapToOutputData(ShipInMemory ship, ShipClassOutputData shipClass) {
        return ShipOutputData.builder().id(ship.getId()).shipClass(shipClass).health(ship.getHealth()).build();
    }
}
