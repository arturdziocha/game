package com.ara.game.usecases.battleship.player;

import com.ara.game.usecases.battleship.player.dto.PlayerCreateDTO;
import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;
import com.google.inject.Inject;

import io.vavr.control.Either;

public final class PlayerFacade {
    private final PlayerCreator creator;
    private final PlayerFinder finder;

    @Inject
    public PlayerFacade(final PlayerGateway playerGateway, final IdGenerator idGenerator) {
        this.creator = new PlayerCreator(playerGateway, idGenerator);
        this.finder = new PlayerFinder(playerGateway);
    }

    public final Either<Error, CreateOutputData> create(PlayerCreateDTO inputData) {
        return creator.create(inputData);
    }

    public Either<Error, PlayerDTO> find(String id) {
        return finder.find(id);
    }
}
