package com.cami_dev.gaceta_ingles.services.impl;

import com.cami_dev.gaceta_ingles.dtos.UsuarioRequestDTO;
import com.cami_dev.gaceta_ingles.dtos.UsuarioResponseDTO;
import com.cami_dev.gaceta_ingles.models.Usuario;
import com.cami_dev.gaceta_ingles.repositories.UsuarioRepository;
import com.cami_dev.gaceta_ingles.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // Inyecta el repositorio atomaticamente, por lo que no tenemos que usar @Autowired que es una mala practica
public class UsuarioServiceImpl implements UsuarioService {
    //Al ser final es inmutable, nadie deberia poder modificar el repository
    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO request){

        //valida que el email no haya sido registrado antes
        if(usuarioRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException("El email ya ha sido registrado");
        }

        Usuario nuevoUsuario = new Usuario(request.email(), request.nombre());

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        return mapearAResponseDTO(usuarioGuardado);
    }

    @Override
    @Transactional(readOnly = true) //optimiza rendimiento ya que avisamos que no vamos a modificar
    public UsuarioResponseDTO obtenerUsuarioPorId(Long id){

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

        return mapearAResponseDTO(usuario);
    }

    private UsuarioResponseDTO mapearAResponseDTO(Usuario usuario){

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }
}
