package com.cami_dev.gaceta_ingles.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacio")
        String nombre,
        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El formato del email no es valido")
        String email
) {}
