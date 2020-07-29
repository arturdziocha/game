package com.ara.game.usecases.battleship.ship;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.ship.dtos.ShipCreateInputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.google.inject.Guice;
import com.google.inject.Injector;

import io.vavr.control.Either;

class ShipFacadeTest {
    private ShipFacade shipFacade;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new ConsoleModule());
        shipFacade = injector.getInstance(ShipFacade.class);
    }

    @Test
    @DisplayName("Should return Either.left when inputData is null")
    void test1() {
        //Given
        ShipCreateInputData createInputData = null;
        //When
        Either<Error, CreateOutputData> ship = shipFacade.create(createInputData);
        //Then
        assertThat(ship.getLeft().getCause()).isEqualTo("Data cannot be null");        
    }
    @Test
    @DisplayName("Should return Either.left when shipClassShortName is null")
    void test2() {
        //TODO
    }

}
