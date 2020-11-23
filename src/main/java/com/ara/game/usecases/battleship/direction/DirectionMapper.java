package com.ara.game.usecases.battleship.direction;

import com.ara.game.usecases.battleship.direction.dto.DirectionDTO;

final class DirectionMapper {
    final DirectionDTO mapToDTO(Direction direction) {
        return DirectionDTO.builder().name(direction.getName()).shortName(direction.getShortName()).build();
    }
}
