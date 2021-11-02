package com.haromerop.crudApi.ApiRestCrud.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.haromerop.crudApi.ApiRestCrud.model.Usuario;
import com.haromerop.crudApi.ApiRestCrud.repository.UsuarioRepository;

@DataJpaTest
class UsuarioControllerTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	void testCreateUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNombresUsuario("Juan");
		usuario.setApellidosUsuario("Rojas");
		usuario.setTelefono("3545312");
		usuario.setDireccion("Calle 15 1 2");
		
		Usuario saveUser = usuarioRepository.save(usuario);
		
		assertNotNull(saveUser);		
	}
	
	@Test
	void testGetAllUsuarios() {
		
		testCreateUsuario();
		
		List<Usuario> users = usuarioRepository.findAll();
		
		assertThat(users).size().isGreaterThan(0);
	}
	
	@Test
	void testGetUsuarioById() {
		
		testCreateUsuario();
		
		Optional<Usuario> user = usuarioRepository.findById((long) 1);
		
		assertNotNull(user);
	}	
	
	@Test
	void testUpdateUsuario() {
		
		testCreateUsuario();
		
		Optional<Usuario> user = usuarioRepository.findById((long) 1);
		Usuario userUpdate = user.get();

		String nameUser = "Adrian";
		String lastNameUser = "Saenz";
		String telephone = "7894561";
		String address = "Calle 5 5 15";
		
		userUpdate.setNombresUsuario(nameUser);
		userUpdate.setApellidosUsuario(lastNameUser);
		userUpdate.setTelefono(telephone);
		userUpdate.setDireccion(address);
		usuarioRepository.save(userUpdate);
		
		assertThat(userUpdate.getNombresUsuario().compareTo(nameUser));
		assertThat(userUpdate.getApellidosUsuario().compareTo(lastNameUser));
		assertThat(userUpdate.getTelefono().compareTo(telephone));
		assertThat(userUpdate.getDireccion().compareTo(address));
	}
	
	
	@Test
	void testDeleteUsuario() {
		
		testCreateUsuario();
		
		Long id = (long) 1;
		
		boolean userBeforeDelete = usuarioRepository.findById(id).isPresent();
		
		usuarioRepository.deleteById(id);
		
		boolean userAfterDelete = usuarioRepository.findById(id).isPresent();
		
		assertTrue(userBeforeDelete);
		assertFalse(userAfterDelete);
	}
}
