package com.alluracursos.foroHub.domain.answer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerFormDTO(
        @NotBlank String mensaje,
        @NotNull Long topicoId,
        @NotNull Long autorId
) {}

