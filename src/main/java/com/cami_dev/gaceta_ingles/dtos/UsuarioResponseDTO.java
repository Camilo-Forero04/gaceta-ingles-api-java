package com.cami_dev.gaceta_ingles.dtos;

public record UsuarioResponseDTO(
        Long id,
        String nombre,
        String email,
        String rol
) {
}
