package com.wlorente.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.cursomc.domain.Cliente;
import com.wlorente.cursomc.repositories.ClienteRepository;
import com.wlorente.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired  // auto instanciar o servico
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName() ));
		
	}

}
