package com.cami_dev.gaceta_ingles.services;


import com.cami_dev.gaceta_ingles.dtos.UsuarioRequestDTO;
import com.cami_dev.gaceta_ingles.dtos.UsuarioResponseDTO;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request);
    UsuarioResponseDTO obtenerUsuarioPorId(Long id);
}
