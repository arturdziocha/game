package com.ara.game.usecases.battleship.game;

import com.ara.game.usecases.battleship.game.port.GameGateway;
import com.ara.game.usecases.common.port.IdGenerator;

final class GameCreator {
    private final GameGateway gameGateway;
    private final IdGenerator idGenerator;

    public GameCreator(final GameGateway gameGateway, final IdGenerator idGenerator) {
        this.gameGateway = gameGateway;
        this.idGenerator = idGenerator;
    }

}
