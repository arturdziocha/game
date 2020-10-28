package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipInputData;

final class PlayerShipMapper {
    final PlayerShipInputData mapToDTO(PlayerShip player) {
        return PlayerShipInputData.builder().playerId(player.getPlayerId()).shipId(player.getShipId()).build();
    }
}
