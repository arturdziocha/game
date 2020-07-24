package com.ara.game.usecases.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
public class CreateOutputData {
    @Getter
    private final String id;
}