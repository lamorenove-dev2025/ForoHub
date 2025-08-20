package com.alluracursos.foroHub.domain.user;

import jakarta.validation.constraints.NotBlank;

public record UserAuthenticationData(@NotBlank String login, @NotBlank  String password) {
}
