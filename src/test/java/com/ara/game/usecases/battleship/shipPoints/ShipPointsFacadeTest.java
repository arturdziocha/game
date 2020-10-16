package com.ara.game.usecases.battleship.shipPoints;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.point.PointFacade;
import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.dto.PointsCreateInputData;
import com.ara.game.usecases.battleship.ship.ShipFacade;
import com.ara.game.usecases.battleship.ship.dto.ShipCreateInputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsCreateInputData;
import com.ara.game.usecases.battleship.shipPoints.dto.ShipPointsOutputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ShipPointsFacadeTest {

    private ShipPointsFacade shipPointsFacade;
    private PointFacade pointFacade;
    private ShipFacade shipFacade;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ConsoleModule());
        shipPointsFacade = injector.getInstance(ShipPointsFacade.class);
        pointFacade = injector.getInstance(PointFacade.class);

        shipFacade = injector.getInstance(ShipFacade.class);
    }

    @Test
    @DisplayName("Should create Carrier with startPoint C4 and direction down")
    void test1() {
        // Given
        Either<Error, CreateOutputData> ship = shipFacade
                .create(ShipCreateInputData.builder().shipClassShortName("c").build());
        Either<Error, ShipOutputData> s = shipFacade.findById(ship.get().getId());
        Either<Error, CreateOutputData> startPoint = pointFacade
                .create(PointCreateRowColInputData.builder().row(1).column(1).build());
        Either<Error, PointOutputData> p = pointFacade.findById(startPoint.get().getId());
        Either<Error, List<CreateOutputData>> points = pointFacade
                .createPoints(PointsCreateInputData
                        .builder()
                        .point(p.get())
                        .size(s.get().getShipClass().getSize())
                        .directionShortName("d")
                        .build());
        // When
        List<String> pointIds = points.get().stream().map(CreateOutputData::getId).collect(Collectors.toList());
        shipPointsFacade
                .placePoints(ShipPointsCreateInputData
                        .builder()
                        .points(pointIds)
                        .shipId(ship.get().getId())
                        .build());

        // Then
        System.out.println(ship.get().getId());
        Either<Error, ShipPointsOutputData> pointsOutputData = shipPointsFacade.findPoints(ship.get().getId());
        System.out.println(pointsOutputData);
        List<String> shipPointsIds =
                pointsOutputData.get().getShipPoints().stream().map(PointOutputData::getId).collect(Collectors.toList());
        assertThat(pointIds).containsAll(shipPointsIds);

        //TODO End the test
    }

}
