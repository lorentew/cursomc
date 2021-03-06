package com.wlorente.cursomc.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wlorente.cursomc.domain.Categoria;
import com.wlorente.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias") // nome do endpoint
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // requisicao basica, POST seria para alterar ou inserir dados DELETE para remover
	public ResponseEntity<?> find(@PathVariable Integer id) {
       
	   Categoria obj = service.buscar(id);
       
       return ResponseEntity.ok().body(obj);
       
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
