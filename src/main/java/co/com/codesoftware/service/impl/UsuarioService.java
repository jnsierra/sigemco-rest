package co.com.codesoftware.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.codesoftware.entity.UsuarioEntity;
import co.com.codesoftware.repository.IUsuarioRepository;
import co.com.codesoftware.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.getAll();
	}

	@Override
	public Boolean validateAuth(String usuario, String contra) {
		return usuarioRepository.authenticateUser(usuario, contra).isPresent();
	}
}
