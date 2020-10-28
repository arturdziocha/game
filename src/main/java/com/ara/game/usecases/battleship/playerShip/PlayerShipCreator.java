package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.battleship.player.port.PlayerGateway;
import com.ara.game.usecases.battleship.playerShip.port.PlayerShipGateway;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;

final class PlayerShipCreator {
    private final PlayerShipGateway playerShipGateway;
    private final PlayerGateway playerGateway;
    private final ShipGateway shipGateway;
    private final ShipClassFacade shipClassFacade;
    private final PlayerShipValidator validator;
    private final PlayerShipMapper mapper;

    public PlayerShipCreator(PlayerShipGateway playerShipGateway, PlayerGateway playerGateway, ShipGateway shipGateway,
            ShipClassFacade shipClassFacade) {
        this.playerShipGateway = playerShipGateway;
        this.playerGateway = playerGateway;
        this.shipGateway = shipGateway;
        this.shipClassFacade = shipClassFacade;
        this.validator = new PlayerShipValidator();
        this.mapper = new PlayerShipMapper();
    }
}
