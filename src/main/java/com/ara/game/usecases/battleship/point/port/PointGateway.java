package com.ara.game.usecases.battleship.point.port;

import com.ara.game.usecases.battleship.point.dto.PointOutputData;

import io.vavr.collection.Seq;
import io.vavr.control.Option;

public interface PointGateway {
    PointOutputData save(PointOutputData point);

    Option<PointOutputData> findById(String id);

    Option<PointOutputData> findByRowAndColumn(Integer row, Integer column);

    Option<PointOutputData> findByPointString(String pointString);

    Option<Seq<PointOutputData>> findAllById(Seq<String> points);

}