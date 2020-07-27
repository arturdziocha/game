package com.ara.game.usecases.battleship.playerType;

import java.util.List;

import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

public class PlayerTypeFacade {
    private final PlayerTypeFinder finder;

    public PlayerTypeFacade() {
        PlayerTypeMapper mapper = new PlayerTypeMapper();
        this.finder = new PlayerTypeFinder(mapper);
    }

    public final Either<Error, PlayerTypeOutputData> findById(String id) {
        return finder.findById(id);
    }

    public final Either<Error, PlayerTypeOutputData> findByName(String name) {
        return finder.findByName(name);
    }

    public final List<PlayerTypeOutputData> findAll() {
        return finder.findAll();
    }
}