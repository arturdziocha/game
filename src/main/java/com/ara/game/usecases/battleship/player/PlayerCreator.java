package com.ara.game.usecases.battleship.player;

import com.ara.game.usecases.battleship.player.dto.PlayerCreateDTO;
import com.ara.game.usecases.battleship.player.dto.PlayerDTO;
import com.ara.game.usecases.battleship.player.port.PlayerGateway;
import com.ara.game.usecases.battleship.playerType.PlayerTypeFacade;
import com.ara.game.usecases.battleship.playerType.dto.PlayerTypeDTO;
import com.ara.game.usecases.common.CreateOutputData;
import com.ara.game.usecases.common.Error;
import com.ara.game.usecases.common.port.IdGenerator;

import io.vavr.control.Either;
import io.vavr.control.Option;

final class PlayerCreator {
    private final PlayerGateway playerGateway;
    private final IdGenerator idGenerator;
    private final PlayerValidator validator;
    private final PlayerTypeFacade playerTypeFacade;
    private final PlayerMapper mapper;

    public PlayerCreator(final PlayerGateway playerGateway, final IdGenerator idGenerator) {
        this.playerGateway = playerGateway;
        this.idGenerator = idGenerator;
        this.validator = new PlayerValidator();
        this.playerTypeFacade = new PlayerTypeFacade();
        this.mapper = new PlayerMapper();
    }

    final Either<Error, CreateOutputData> create(PlayerCreateDTO inputData) {        
        Option<Error> validated = validator.validate(inputData);
        if (validated.isDefined()) {
            return Either.left(validated.get());
        }
        Either<Error, PlayerTypeDTO> playerType = playerTypeFacade.findById(inputData.getPlayerTypeId());
        if (playerType.isRight()) {
            Player player = Player
                    .builder()
                    .id(idGenerator.generate())
                    .name(inputData.getName())
                    .playerTypeId(inputData.getPlayerTypeId())
                    .build();
            PlayerDTO dto = playerGateway.save(mapper.mapToPlayerDTO(player));
            return Either.right(mapper.mapToCreateOutput(dto));
        } else {
            return Either.left(playerType.getLeft());
        }
    }
}
