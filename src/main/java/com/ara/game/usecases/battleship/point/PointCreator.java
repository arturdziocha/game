package com.ara.game.usecases.battleship.point;

import java.util.Arrays;
import java.util.List;

import com.ara.game.usecases.battleship.point.dto.PointCreateRowColInputData;
import com.ara.game.usecases.battleship.point.dto.PointCreateStringInputData;
import com.ara.game.usecases.battleship.point.dto.PointOutputData;
import com.ara.game.usecases.battleship.point.port.PointGateway;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.port.IdGenerator;
import com.ara.game.usecases.common.Error;

import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;

final class PointCreator {
    private final PointGateway pointGateway;
    private final IdGenerator idGenerator;
    private final PointMapper mapper;
    private final Validator validator;
   
    private final List<Character> chars = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'W', 'X', 'Y', 'Z');

    PointCreator(final PointGateway pointGateway, final IdGenerator idGenerator, final PointMapper mapper) {
        this.pointGateway = pointGateway;
        this.idGenerator = idGenerator;
        this.mapper = mapper;
        this.validator = new Validator();
    }

    final Either<Error, CreateOutputData> create(PointCreateStringInputData inputData) {
        Option<Error> validationCheck = validator.validatePointString(inputData);
        if (validationCheck.isDefined()) {
            return Either.left(validationCheck.get());
        }
        String pointString = inputData.getPointString().toUpperCase();
        Option<PointOutputData> find = pointGateway.findByPointString(pointString);
        if (find.isDefined()) {
            return Either.right(mapper.mapToCreatePointOutput(find.get()));
        } else {
            Either<Error, CreateOutputData> output;
            Either<Error, Integer> row = getRow(pointString);
            Either<Error, Integer> column = getColumn(pointString);
            if (row.isRight() && column.isRight()) {
                Point point = Point
                        .builder()
                        .id(idGenerator.generate())
                        .row(row.get())
                        .column(column.get())
                        .pointString(pointString)
                        .build();
                PointOutputData dto = pointGateway.save(mapper.mapToDTO(point));
                output = Either.right(mapper.mapToCreatePointOutput(dto));
            } else if (row.isLeft()) {
                output = Either.left(row.getLeft());
            } else {
                output = Either.left(column.getLeft());
            }
            return output;

        }
    }

    final Either<Error, CreateOutputData> create(PointCreateRowColInputData inputData) {
        Option<Error> validationCheck = validator.validateRowCol(inputData);
        if (validationCheck.isDefined()) {
            return Either.left(validationCheck.get());
        }
        Option<PointOutputData> find = pointGateway.findByRowAndColumn(inputData.getRow(), inputData.getColumn());
        if (find.isDefined()) {
            return Either.right(mapper.mapToCreatePointOutput(find.get()));
        } else {
            Either<Error, CreateOutputData> output;
            Either<Error, String> pointString = pointToString(inputData.getRow(), inputData.getColumn());
            if (pointString.isRight()) {
                Point point = Point
                        .builder()
                        .id(idGenerator.generate())
                        .row(inputData.getRow())
                        .column(inputData.getColumn())
                        .pointString(pointString.get())
                        .build();

                PointOutputData dto = pointGateway.save(mapper.mapToDTO(point));

                output = Either.right(mapper.mapToCreatePointOutput(dto));
            } else {
                output = Either.left(pointString.getLeft());
            }
            return output;
        }
    }

    private Either<Error, String> pointToString(int row, int column) {
        Try<Character> tryCharacter = Try.of(() -> chars.get(column));
        if (tryCharacter.isFailure()) {
            return Either.left(PointError.WRONG_COLUMN_SPECIFIED);
        }
        String builder = String.valueOf(tryCharacter.get()) + (row + 1);
        return Either.right(builder);
    }

    private Either<Error, Integer> getColumn(String pointString) {
        char posY = pointString.charAt(0);
        int y = chars.indexOf(posY);
        return y == -1 ? Either.left(PointError.WRONG_COLUMN_SPECIFIED) : Either.right(y);
    }

    private Either<Error, Integer> getRow(String pointString) {
        String posX = pointString.substring(1);
        return Try
                .of(() -> Integer.parseInt(posX))
                .filter(i -> i >= 0)
                .map(val -> val - 1)
                .toEither(PointError.CANNOT_PARSE_STRING);
    }

}
