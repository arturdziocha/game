package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;
import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipCreateDTO;
import com.ara.game.usecases.battleship.playerShip.port.PlayerShipGateway;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipOutputData;
import com.ara.game.usecases.battleship.ship.dto.ShipWithPointsOutputData;
import com.ara.game.usecases.battleship.ship.port.ShipGateway;
import com.ara.game.usecases.battleship.shipclass.ShipClassFacade;
import com.ara.game.usecases.battleship.shipclass.dto.ShipClassOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import io.vavr.control.Option;

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

    final Either<Error, ShipWithPointsOutputData> placeShip(PlayerShipCreateDTO inputData) {
        Option<Error> validated = validator.validate(inputData);
        if (validated.isDefined()) {
            return Either.left(validated.get());
        }
        if (isAllShipsPlaced(inputData.getPlayerId())) {
            removeShip(inputData.getShipId());
            return Either.left(PlayerShipError.ALL_SHIP_PLACED);
        }
        Option<PlayerDTO> player = playerGateway.findById(inputData.getPlayerId());
        if (player.isEmpty()) {
            removeShip(inputData.getShipId());
            return Either.left(PlayerShipError.CANNOT_FIND_RELATED_PLAYER);
        }
        Option<ShipWithPointsOutputData> ship = shipGateway.findByIdWithPoints(inputData.getShipId());
        if (ship.isEmpty()) {
            removeShip(inputData.getShipId());
            return Either.left(PlayerShipError.CANNOT_FIND_RELATED_SHIP);
        }
        if (isAlreadyPlaced(inputData.getPlayerId(), ship.get().getShipClass().getShortName()).isDefined()) {
            return Either.left(PlayerShipError.SHIP_IS_ALREADY_PLACED);
        }
        Option<Seq<ShipWithPointsOutputData>> placedShips = playerShipGateway.find(player.get().getId());
        if (placedShips.isDefined()) {
            if (isToCloseTo(placedShips.get(), ship.get().getPoints())) {
                removeShip(inputData.getShipId());
                return Either.left(PlayerShipError.SHIP_IS_TO_CLOSE_OTHER);
            }
        }
        PlayerShip playerShip = PlayerShip
                .builder()
                .playerId(inputData.getPlayerId())
                .shipId(inputData.getShipId())
                .build();
        playerShipGateway.save(mapper.mapToDTO(playerShip));
        return ship.toEither(PlayerShipError.PLAYER_SHIP_NOT_FOUND);
    }

    private boolean isAllShipsPlaced(String playerId) {
        Option<Seq<ShipWithPointsOutputData>> alreadyPlaced = playerShipGateway.find(playerId);
        if (alreadyPlaced.isEmpty()) {
            return false;
        }
        Seq<String> alreadyPlacedShortNames = alreadyPlaced
                .get()
                .map(ship -> ship.getShipClass().getShortName())
                .sortBy(String::toString);
        Seq<String> shipClasses = shipClassFacade
                .findAll()
                .map(ShipClassOutputData::getShortName)
                .sortBy(String::toString);
        return alreadyPlacedShortNames.containsAll(shipClasses);

    }

    private void removeShip(String shipId) {
        shipGateway.remove(shipId);
    }

    private Option<ShipOutputData> isAlreadyPlaced(String playerId, String shipClassShortName) {
        return playerShipGateway.findByPlayerIdAndShipClassShortName(playerId, shipClassShortName);
    }

    private boolean isToCloseTo(Seq<ShipWithPointsOutputData> placedShips, Seq<PointOutputData> shipPoints) {
        Seq<PointOutputData> placed = placedShips.flatMap(ShipWithPointsOutputData::getPoints);
        for (PointOutputData point : placed) {
            for (PointOutputData shipPoint : shipPoints) {
                if (isNeighbor(point, shipPoint)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNeighbor(PointOutputData point, PointOutputData other) {
        return (Math.abs(point.getRow() - other.getRow()) <= 1)
                && (Math.abs(point.getColumn() - other.getColumn()) <= 1);
    }
}
