package com.ara.game.adapter.repository.battleship.inmemory.entity;

import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;

public class ShipPointsMapper {   

    public ShipPointsOutputData mapToOutputData(String shipId, List<PointOutputData> shipPoints) {
        return ShipPointsOutputData.builder().shipId(shipId).shipPoints(shipPoints).build();
    }
}
