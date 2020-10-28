package com.ara.game.usecases.battleship.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.player.dtos.PlayerCreateInputData;
import com.ara.game.usecases.battleship.player.dtos.PlayerOutputData;
import com.ara.game.usecases.battleship.playerType.PlayerTypeFacade;
import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeOutputData;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.google.inject.Guice;
import com.google.inject.Injector;

import io.vavr.control.Either;

class PlayerFacadeTest {
    private PlayerFacade playerFacade;
    private PlayerTypeFacade playerTypeFacade;

    @Test
    void before() {
        Injector injector = Guice.createInjector(new ConsoleModule());
        playerFacade = injector.getInstance(PlayerFacade.class);
        playerTypeFacade = new PlayerTypeFacade();
    }

    @Test
    @DisplayName("Should return Either.left when input data is null")
    void test() {
        // Given
        PlayerCreateInputData input = null;
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        System.out.println(player);
        assertThat(player.getLeft().getCause()).isEqualTo("Data cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player name is null")
    void test1() {
        // Given
        PlayerCreateInputData input = PlayerCreateInputData.builder().name(null).playerTypeId("1").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Name cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player name is empty")
    void test2() {
        // Given
        PlayerCreateInputData input = PlayerCreateInputData.builder().name("").playerTypeId("1").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        // TODO
        assertThat(player.getLeft().getCause()).isEqualTo("Name cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player type is null")
    void test3() {
        // Given
        PlayerCreateInputData input = PlayerCreateInputData.builder().name("Artur").playerTypeId(null).build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Type of player cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player type is empty string")
    void test4() {
        // Given
        PlayerCreateInputData input = PlayerCreateInputData.builder().name("Artur").playerTypeId("").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Type of player cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player type is not found")
    void test5() {
        // Given
        PlayerCreateInputData input = PlayerCreateInputData.builder().name("Artur").playerTypeId("5").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Cannot find player type");
    }

    @Test
    @DisplayName("Should create player")
    void test6() {
        // Given
        Either<Error, PlayerTypeOutputData> playerType = playerTypeFacade.findById("1");
        // When
        PlayerCreateInputData input = PlayerCreateInputData
                .builder()
                .name("Artur")
                .playerTypeId(playerType.get().getId())
                .build();
        Either<Error, CreateOutputData> player = playerFacade.create(input);

        // Then
        Either<Error, PlayerOutputData> output = playerFacade.find(player.get().getId());
        assertThat(output.get().getName()).isEqualTo("Artur");

    }
}
