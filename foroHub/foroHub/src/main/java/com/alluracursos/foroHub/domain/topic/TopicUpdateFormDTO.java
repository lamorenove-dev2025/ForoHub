package com.alluracursos.foroHub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateFormDTO(
        @NotNull Long id,
        @NotBlank String message,
        @NotBlank String courseName,
        @NotBlank String title
        ){
}