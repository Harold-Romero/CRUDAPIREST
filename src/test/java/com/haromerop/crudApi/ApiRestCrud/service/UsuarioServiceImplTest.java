package com.haromerop.crudApi.ApiRestCrud.service;

import com.haromerop.crudApi.ApiRestCrud.dto.UsuarioRequest;
import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.repository.UsuarioRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario user;

    private UsuarioRequest usuarioRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        //usuarioRequest.setNombresUsuario("Juan");
        //usuarioRequest.setApellidosUsuario("Lee");
        //usuarioRequest.setTelefono("7894611");
        //usuarioRequest.setDireccion("Calle 15 2 1");
    }

    @Test
    void createUsuario() {
        //when(repository.save(user)).thenReturn(user);
        //assertNotNull(usuarioService.createUsuario(usuarioRequest));
    }

    @Test
    void updateUsuario() {
    }

    @Test
    void getAllUsuario() {
        //when(repository.findAll()).thenReturn(Arrays.asList(user));
        //assertNotNull(usuarioService.getAllUsuario());
    }

    @Test
    void getUsuarioById() {
    }

    @Test
    void deleteUsuario() {
    }
}