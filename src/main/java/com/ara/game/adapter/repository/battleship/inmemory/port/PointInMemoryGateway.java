package com.ara.game.adapter.repository.battleship.inmemory.port;

import com.ara.game.adapter.repository.battleship.inmemory.entity.PointInMemory;
import com.ara.game.adapter.repository.battleship.inmemory.entity.PointMapper;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.port.PointGateway;

import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class PointInMemoryGateway implements PointGateway {
    private Map<String, PointInMemory> entities;
    private PointMapper mapper;

    public PointInMemoryGateway() {
        this.entities = HashMap.empty();
        this.mapper = new PointMapper();
    }

    @Override
    public PointOutputData save(PointOutputData point) {
        entities = entities.put(point.getId(), mapper.mapToEntity(point));
        return point;
    }

    @Override
    public Option<PointOutputData> findById(String id) {
        return entities.get(id).map(mapper::mapToOutputData);
    }

    @Override
    public Option<PointOutputData> findByRowAndColumn(Integer row, Integer column) {
        return entities
                .values()
                .find(entity -> entity.getRow().equals(row) && entity.getColumn().equals(column))
                .map(mapper::mapToOutputData);
    }

    @Override
    public Option<PointOutputData> findByPointString(String pointString) {
        return entities
                .values()
                .find(entity -> entity.getPointString().equals(pointString))
                .map(mapper::mapToOutputData);
    }

    @Override
    public Option<Seq<PointOutputData>> findAllById(Seq<String> points) {
        Seq<PointOutputData> collection = List.empty();
        for (String id : points) {
            Option<PointInMemory> option = entities.get(id);
            if (option.isEmpty()) {
                return Option.none();
            } else {
                collection = collection.append(mapper.mapToOutputData(option.get()));
            }
        }
        return Option.of(collection);
    }
}
