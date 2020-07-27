package com.ara.game.usecases.battleship.ship;

import com.ara.game.usecases.common.domain.Entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
final class Ship extends Entity {
    @Getter
    private final String shipClassShortName;
    @Getter
    private final Integer health;

}