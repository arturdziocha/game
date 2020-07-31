package com.ara.game.usecases.battleship.shipPoints.port;

import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;

import io.vavr.control.Option;

public interface ShipPointsGateway {
    ShipPointsCreateInputData saveAll(ShipPointsCreateInputData shipPoints);

    Option<ShipPointsOutputData> findByShipId(String shipId);

    void remove(String shipId);
}
