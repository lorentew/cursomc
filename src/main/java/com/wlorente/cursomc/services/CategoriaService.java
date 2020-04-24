package com.wlorente.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.cursomc.domain.Categoria;
import com.wlorente.cursomc.repositories.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService {
	
	@Autowired  // auto instanciar o servico
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
		
	}

}
