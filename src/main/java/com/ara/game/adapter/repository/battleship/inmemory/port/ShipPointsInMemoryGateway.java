package com.ara.game.adapter.repository.battleship.inmemory.port;



import com.ara.game.adapter.repository.battleship.inmemory.entity.ShipPointsMapper;
import com.ara.game.usecases.battleship.point.port.PointGateway;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.google.inject.Inject;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class ShipPointsInMemoryGateway implements ShipPointsGateway {
    private Map<String, Seq<String>> entities;
    private final PointGateway pointGateway;
    private final ShipPointsMapper mapper;

    @Inject
    public ShipPointsInMemoryGateway(PointGateway pointGateway) {
        this.entities = HashMap.empty();
        this.pointGateway = pointGateway;
        this.mapper = new ShipPointsMapper();
    }

    @Override
    public ShipPointsCreateInputData saveAll(ShipPointsCreateInputData shipPoints) {
        entities = entities.put(shipPoints.getShipId(), shipPoints.getPoints());
        return shipPoints;
    }

    @Override
    public Option<ShipPointsOutputData> findByShipId(String shipId) {        
        return entities.get(shipId)
                .flatMap(s -> pointGateway.findAllById(s).map(w -> mapper.mapToOutputData(shipId, w)));
    }

    @Override
    public void remove(String shipId) {
        entities.remove(shipId);

    }

}
