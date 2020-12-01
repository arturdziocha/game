package com.ara.game.usecases.battleship.playerShip;

import com.ara.game.usecases.battleship.playerShip.dto.PlayerShipCreateDTO;

final class PlayerShipMapper {
    final PlayerShipCreateDTO mapToDTO(PlayerShip player) {
        return PlayerShipCreateDTO.builder().playerId(player.getPlayerId()).shipId(player.getShipId()).build();
    }
}
