package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
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

    public ShipWithPointsOutputData mapToOutputDataWithPoints(ShipOutputData ship, ShipPointsOutputData p) {
        return ShipWithPointsOutputData
                .builder()
                .id(ship.getId())
                .health(ship.getHealth())
                .shipClass(ship.getShipClass())
                .points(p.getShipPoints())
                .build();
    }
}
