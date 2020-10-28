package com.ara.game.usecases.battleship.pointStatus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ara.game.usecases.battleship.pointStatus.dto.PointStatusOutputData;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;

class PointStatusFacadeTest {

    private PointStatusFacade pointStatusFacade;

    @BeforeEach
    void setUp() {
        pointStatusFacade = new PointStatusFacade();
    }

    @Test
    @DisplayName("Should return Either left when name is null")
    void test() {
        // Given when
        Either<Error, PointStatusOutputData> pointStatus = pointStatusFacade.findByName(null);
        // Then
        assertThat(pointStatus.getLeft().getCause()).isEqualTo("Name cannot be empty");
    }

    @Test
    @DisplayName("Should return Either left when name is empty string")
    void test1() {
        // Given when
        Either<Error, PointStatusOutputData> pointStatus = pointStatusFacade.findByName("");
        // Then
        assertThat(pointStatus.getLeft().getCause()).isEqualTo("Name cannot be empty");
    }

    @Test
    @DisplayName("Should find pointstatus by name")
    void test2() {
        // Given when
        Either<Error, PointStatusOutputData> pointStatus = pointStatusFacade.findByName("Empty");
        // Then
        assertThat(pointStatus.get().getStatus()).isEqualTo(" ");
        assertThat(pointStatus.get().getName()).isEqualTo("Empty");
    }

    @Test
    @DisplayName("Should return Either left Cannot find point status")
    void test3() {
        // Given when
        Either<Error, PointStatusOutputData> pointStatus = pointStatusFacade.findByName("Not");
        // Then
        assertThat(pointStatus.getLeft().getCause()).isEqualTo("Cannot find point status");
    }

}
