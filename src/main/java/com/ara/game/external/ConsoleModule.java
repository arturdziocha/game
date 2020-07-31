package com.ara.game.external;

import com.ara.game.adapter.id.UuidGenerator;
import com.ara.game.adapter.repository.battleship.inmemory.port.PointInMemoryGateway;
import com.ara.game.adapter.repository.battleship.inmemory.port.ShipInMemoryGateway;
import com.ara.game.adapter.repository.battleship.inmemory.port.ShipPointsInMemoryGateway;
import com.ara.game.usecases.battleship.point.port.PointGateway;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipPoints.port.ShipPointsGateway;
import com.ara.game.usecases.common.port.IdGenerator;
import com.google.inject.AbstractModule;

public class ConsoleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IdGenerator.class).to(UuidGenerator.class);
        bind(PointGateway.class).to(PointInMemoryGateway.class);
        bind(ShipGateway.class).to(ShipInMemoryGateway.class);
        bind(ShipPointsGateway.class).to(ShipPointsInMemoryGateway.class);

    }
}
