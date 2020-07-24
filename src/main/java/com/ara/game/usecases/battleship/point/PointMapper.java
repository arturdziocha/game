package com.ara.game.usecases.battleship.point;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.common.CreateOutputData;

final class PointMapper {
    final PointOutputData mapToDTO(Point point) {
        return PointOutputData
                .builder()
                .id(point.getId())
                .pointString(point.getPointString())
                .row(point.getRow())
                .column(point.getColumn())
                .build();
    }

    final CreateOutputData mapToCreatePointOutput(PointOutputData point) {
        return CreateOutputData.builder().id(point.getId()).build();
    }

}