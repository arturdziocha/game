package com.ara.game.usecases.battleship.pointStatus;

import com.ara.game.usecases.battleship.pointStatus.dto.PointStatusOutputData;

final class PointStatusMapper {
    final PointStatusOutputData mapToOutputData(PointStatus pointStatus) {
        return PointStatusOutputData.builder().name(pointStatus.getName()).status(pointStatus.getStatus()).build();
    }
}

