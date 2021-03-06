package com.ara.game.usecases.battleship.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.external.ConsoleModule;
import com.ara.game.usecases.battleship.player.dto.PlayerCreateDTO;
import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.battleship.playerType.PlayerTypeFacade;
import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.google.inject.Guice;
import com.google.inject.Injector;

import io.vavr.control.Either;

class PlayerFacadeTest {
    private PlayerFacade playerFacade;
    private PlayerTypeFacade playerTypeFacade;

    @BeforeEach
    void before() {
        Injector injector = Guice.createInjector(new ConsoleModule());
        playerFacade = injector.getInstance(PlayerFacade.class);
        playerTypeFacade = new PlayerTypeFacade();
    }

    @Test
    @DisplayName("Should return Either.left when input data is null")
    void test() {
        // Given
        PlayerCreateDTO input = null;
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Data cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player name is null")
    void test1() {        
        // Given
        Either<Error, PlayerTypeDTO> playerType = playerTypeFacade.findById("1");
        PlayerCreateDTO input = PlayerCreateDTO.builder().name(null).playerType(playerType.get()).build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Name cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player name is empty")
    void test2() {
        // Given
        Either<Error, PlayerTypeDTO> playerType = playerTypeFacade.findById("1");
        PlayerCreateDTO input = PlayerCreateDTO.builder().name("").playerType(playerType.get()).build();
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
        PlayerCreateDTO input = PlayerCreateDTO.builder().name("Artur").playerType(null).build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Type of player cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player type is empty string")
    void test4() {
        // Given
        PlayerCreateDTO input = PlayerCreateDTO.builder().name("Artur").playerType("").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Type of player cannot be empty");
    }

    @Test
    @DisplayName("Should return Either.left when player type is not found")
    void test5() {
        // Given
        PlayerCreateDTO input = PlayerCreateDTO.builder().name("Artur").playerTypeId("5").build();
        // When
        Either<Error, CreateOutputData> player = playerFacade.create(input);
        // Then
        assertThat(player.getLeft().getCause()).isEqualTo("Cannot find player type");
    }

    @Test
    @DisplayName("Should create player")
    void test6() {
        // Given
        Either<Error, PlayerTypeDTO> playerType = playerTypeFacade.findById("1");
        // When
        PlayerCreateDTO input = PlayerCreateDTO
                .builder()
                .name("Artur")
                .playerTypeId(playerType.get().getId())
                .build();
        Either<Error, CreateOutputData> player = playerFacade.create(input);

        // Then
        Either<Error, PlayerDTO> output = playerFacade.find(player.get().getId());
        assertThat(output.get().getName()).isEqualTo("Artur");

    }
}
