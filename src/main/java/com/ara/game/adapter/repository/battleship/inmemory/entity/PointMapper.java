package com.ara.game.adapter.repository.battleship.inmemory.entity;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;

public class PointMapper {
    public PointInMemory mapToEntity(PointOutputData point) {
        return PointInMemory
                .builder()
                .id(point.getId())
                .row(point.getRow())
                .column(point.getColumn())
                .pointString(point.getPointString())
                .build();
    }

    public PointOutputData mapToOutputData(PointInMemory point) {
        return PointOutputData
                .builder()
                .id(point.getId())
                .row(point.getRow())
                .column(point.getColumn())
                .pointString(point.getPointString())
                .build();
    }
}
