package com.ara.game.usecases.battleship.ship;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.ship.dto.ShipCreateInputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
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
      //Given
        ShipCreateInputData createInputData = ShipCreateInputData.builder().shipClassShortName(null).build();
        //When
        Either<Error, CreateOutputData> ship = shipFacade.create(createInputData);
        //Then
        assertThat(ship.getLeft().getCause()).isEqualTo("Class of ship cannot be empty"); 
    }
    @Test
    @DisplayName("Should create Ship Submarine")
    void test3() {
      //Given
        ShipCreateInputData createInputData = ShipCreateInputData.builder().shipClassShortName("s").build();
        //When
        Either<Error, CreateOutputData> ship = shipFacade.create(createInputData);
        //Then
        Either<Error, ShipOutputData> findShip = shipFacade.findById(ship.get().getId());
        assertThat(findShip.get().getHealth()).isEqualByComparingTo(3);
        assertThat(findShip.get().getShipClass().getName()).isEqualTo("Submarine");
    }

}
