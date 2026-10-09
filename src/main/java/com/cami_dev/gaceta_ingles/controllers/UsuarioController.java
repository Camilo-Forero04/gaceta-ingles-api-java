package com.cami_dev.gaceta_ingles.controllers;

import com.cami_dev.gaceta_ingles.dtos.UsuarioRequestDTO;
import com.cami_dev.gaceta_ingles.dtos.UsuarioResponseDTO;
import com.cami_dev.gaceta_ingles.models.Usuario;
import com.cami_dev.gaceta_ingles.services.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService; //Como solo tenemos una implementacion de este metodo, spring toma UsuarioServiceImpl, si hubieran mas no arrancaria a menos que tuviera un @Qualifier("nombreDelServicio")

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@Valid @RequestBody UsuarioRequestDTO request){
        UsuarioResponseDTO nuevoUsuario = usuarioService.crearUsuario(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @GetMapping
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id){
        UsuarioResponseDTO usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }
}
