package com.ara.game.adapter.repository.battleship.inmemory.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ara.game.adapter.repository.battleship.inmemory.entity.point.PointInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.point.PointMapper;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.port.PointGateway;

import io.vavr.control.Option;

public class PointInMemoryGateway implements PointGateway {
    private Map<String, PointInMemory> entities;
    private PointMapper mapper;

    public PointInMemoryGateway() {
        this.entities = new HashMap<>();
        this.mapper = new PointMapper();
    }

    @Override
    public PointOutputData save(PointOutputData point) {
        entities.put(point.getId(), mapper.mapToEntity(point));
        return point;
    }

    @Override
    public Option<PointOutputData> findById(String id) {
        return Option.of(entities.get(id)).map(mapper::mapToOutputData);
    }

    @Override
    public Option<PointOutputData> findByRowAndColumn(Integer row, Integer column) {
        return Option
                .ofOptional(entities
                        .values()
                        .stream()
                        .filter(entity -> entity.getRow().equals(row) && entity.getColumn().equals(column))
                        .findFirst()
                        .map(mapper::mapToOutputData));
    }

    @Override
    public Option<PointOutputData> findByPointString(String pointString) {
        return Option
                .ofOptional(entities
                        .values()
                        .stream()
                        .filter(entity -> pointString.equals(entity.getPointString()))
                        .findFirst()
                        .map(mapper::mapToOutputData));
    }

    @Override
    public Option<List<PointOutputData>> findAllById(List<String> points) {
        List<PointOutputData> collection = new ArrayList<>();
        for (String id : points) {
            if (!entities.containsKey(id)) {
                return Option.none();
            } else {
                collection.add(mapper.mapToOutputData(entities.get(id)));
            }
        }
        return Option.of(collection);
    }

}
