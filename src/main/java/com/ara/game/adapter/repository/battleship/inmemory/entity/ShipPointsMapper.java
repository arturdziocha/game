package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;

import io.vavr.collection.Seq;

public class ShipPointsMapper {   

    public ShipPointsOutputData mapToOutputData(String shipId, Seq<PointOutputData> shipPoints) {
        return ShipPointsOutputData.builder().shipId(shipId).shipPoints(shipPoints).build();
    }
}
