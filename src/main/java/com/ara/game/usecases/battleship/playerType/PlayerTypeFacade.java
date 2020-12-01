package com.ara.game.usecases.battleship.playerType;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;
import com.ara.game.usecases.common.Error;

import io.vavr.collection.Seq;
import io.vavr.control.Either;

public class PlayerTypeFacade {
    private final PlayerTypeFinder finder;

    public PlayerTypeFacade() {
        PlayerTypeMapper mapper = new PlayerTypeMapper();
        this.finder = new PlayerTypeFinder(mapper);
    }

    public final Either<Error, PlayerTypeDTO> findById(String id) {
        return finder.findById(id);
    }

    public final Either<Error, PlayerTypeDTO> findByName(String name) {
        return finder.findByName(name);
    }

    public final Seq<PlayerTypeDTO> findAll() {
        return finder.findAll();
    }
}