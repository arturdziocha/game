package com.ara.game.usecases.battleship.point;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.direction.DirectionFacade;
import com.ara.game.usecases.battleship.direction.dto.DirectionOutputData;
import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointCreateStringInputData;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.dto.PointsCreateInputData;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.google.inject.Guice;
import com.google.inject.Injector;

import io.vavr.control.Either;

class PointFacadeTest {
    private PointFacade pointFacade;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ConsoleModule());
        pointFacade = injector.getInstance(PointFacade.class);
    }

    @Test
    @DisplayName("Should return Either.left when inputData is null")
    void test1() {
        // Given
        PointCreateStringInputData inputData = null;
        // When
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);
        // Then
        assertThat(point.getLeft().getCause()).isEqualTo("Data cannot be null");
    }

    @Test
    @DisplayName("Should return Either.left when pointString is null")
    void test2() {
        // Given
        PointCreateStringInputData inputData = PointCreateStringInputData.builder().pointString(null).build();
        // When
        // Then
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);
        assertThat(point.isLeft()).isTrue();
    }

    @Test
    @DisplayName("Should return Either.left Point String cannot be empty")
    void test3() {
        // Given
        PointCreateStringInputData inputData = PointCreateStringInputData.builder().pointString("").build();
        // When
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);

        // Then
        assertThat(point.getLeft().getCause()).isEqualTo("Point string cannot be empty");
    }

    @Test
    @DisplayName("Should create and save valid point from string")
    void test4() {
        // Given
        PointCreateStringInputData inputData = PointCreateStringInputData.builder().pointString("a2").build();

        // When
        Either<Error, CreateOutputData> pointId = pointFacade.create(inputData);
        Either<Error, PointOutputData> point = pointFacade.findById(pointId.get().getId());
        // Then
        assertThat(point.get().getPointString()).isEqualTo("A2");
        assertThat(point.get().getRow()).isEqualByComparingTo(1);
        assertThat(point.get().getColumn()).isEqualByComparingTo(0);
    }

    @Test
    @DisplayName("Should return Either.left Point string cannot be parsed")
    void test5() {
        // Given
        PointCreateStringInputData inputData = PointCreateStringInputData.builder().pointString("aa2").build();

        // When
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);

        // Then
        assertThat(point.getLeft().getCause()).isEqualTo("Point string cannot be parsed");
    }

    @Test
    @DisplayName("Should return Either.left When column is null")
    void test6() {
        // Given
        PointCreateRowColInputData inputData = PointCreateRowColInputData.builder().row(1).column(null).build();
        // When
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);
        // Then
        assertThat(point.getLeft().getCause()).isEqualTo("Column cannot be null");
    }

    @Test
    @DisplayName("Should return Either.left When column is negative")
    void test7() {
        // Given
        PointCreateRowColInputData inputData = PointCreateRowColInputData.builder().row(1).column(-1).build();
        // When
        Either<Error, CreateOutputData> point = pointFacade.create(inputData);
        // Then
        assertThat(point.getLeft().getCause()).isEqualTo("Column cannot be negative");
    }

    @Test
    @DisplayName("Should create and save valid point from row=1, column=2")
    void test8() {
        // Given
        PointCreateRowColInputData inputData = PointCreateRowColInputData.builder().row(1).column(2).build();

        // When
        Either<Error, CreateOutputData> pointId = pointFacade.create(inputData);
        Either<Error, PointOutputData> point = pointFacade.findById(pointId.get().getId());

        // Then
        assertThat(point.get().getPointString()).isEqualTo("C2");
        assertThat(point.get().getRow()).isEqualByComparingTo(1);
        assertThat(point.get().getColumn()).isEqualByComparingTo(2);
    }

    @Test
    @DisplayName("Should return Either.left Wrong column specified when row=40, column=1")
    void test9() {
        // Given
        PointCreateRowColInputData inputData = PointCreateRowColInputData.builder().row(1).column(40).build();
        // When
        Either<Error, CreateOutputData> pointId = pointFacade.create(inputData);

        // Then
        assertThat(pointId.getLeft().getCause()).isEqualTo("Wrong column specified");
    }

    @Test
    @DisplayName("Should create 4 points down")
    void shouldCreate4PointsDown() {
        ShipClassFacade shipClassFacade = new ShipClassFacade();
        DirectionFacade directionFacade = new DirectionFacade();
        // Given
        Either<Error, ShipClassOutputData> shipClass = shipClassFacade.findByName("Battleship");
        Either<Error, DirectionOutputData> direction = directionFacade.findByShortName("d");
        Either<Error, CreateOutputData> point = pointFacade
                .create(PointCreateStringInputData.builder().pointString("b2").build());
        Either<Error, PointOutputData> findPoint = pointFacade.findById(point.get().getId());

        PointsCreateInputData spcid = PointsCreateInputData
                .builder()
                .size(shipClass.get().getSize())
                .point(findPoint.get())
                .directionShortName(direction.get().getShortName())
                .build();

        // When
        Either<Error, List<CreateOutputData>> createdPoints = pointFacade.createPoints(spcid);

        List<String> pointStrings = createdPoints
                .get()
                .stream()
                .map(p -> pointFacade.findById(p.getId()))
                .map(Either::get)
                .map(pod -> pod.getPointString())
                .collect(Collectors.toList());

        // Then
        List<String> pStrings = Arrays.asList("B2", "B3", "B4", "B5");
        assertThat(pointStrings).hasSameElementsAs(pStrings);
    }
}