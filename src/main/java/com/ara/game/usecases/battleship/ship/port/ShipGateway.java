package com.ara.game.usecases.battleship.ship.port;

import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;

import io.vavr.collection.Seq;
import io.vavr.control.Option;

public interface ShipGateway {
    ShipOutputData save(ShipOutputData ship);
    Option<ShipOutputData> findById(String shipId);
    Option<Seq<ShipWithPointsOutputData>> findAllById(Seq<String> ids);
    Option<ShipWithPointsOutputData> findByIdWithPoints(String shipId);
    void remove(String shipId);
}
