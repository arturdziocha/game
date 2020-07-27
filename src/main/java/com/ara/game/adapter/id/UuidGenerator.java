package com.ara.game.adapter.id;

import java.util.UUID;

import com.ara.game.usecases.common.port.IdGenerator;

public class UuidGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }

}