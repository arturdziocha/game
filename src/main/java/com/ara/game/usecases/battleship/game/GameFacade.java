package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.dto.GameCreateDTO;
import com.ara.game.usecases.battleship.game.dto.GameDTO;
import com.ara.game.usecases.battleship.game.port.GameGateway;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;
import com.google.inject.Inject;

import io.vavr.control.Either;

public final class GameFacade {
    private final GameCreator creator;
    private final GameFinder finder;

    @Inject
    GameFacade(final GameGateway gameGateway, final IdGenerator idGenerator) {
        this.creator = new GameCreator(gameGateway, idGenerator);
        this.finder = new GameFinder(gameGateway);
    }

    Either<Error, GameDTO> create(GameCreateDTO inputData) {
        return creator.create(inputData);
    }

    Either<Error, GameDTO> find(String id) {
        return finder.find(id);
    }
}
