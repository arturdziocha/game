package com.ara.game.usecases.battleship.direction;

import com.ara.game.usecases.battleship.direction.dto.DirectionOutputData;

final class DirectionMapper {
    final DirectionOutputData mapToDTO(Direction direction) {
        return DirectionOutputData.builder().name(direction.getName()).shortName(direction.getShortName()).build();
    }
}
