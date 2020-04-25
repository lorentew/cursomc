package com.wlorente.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wlorente.cursomc.domain.Cliente;
import com.wlorente.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes") // nome do endpoint
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // requisicao basica, POST seria para alterar ou inserir dados DELETE para remover
	public ResponseEntity<?> find(@PathVariable Integer id) {
       
	   Cliente obj = service.buscar(id);
       
       return ResponseEntity.ok().body(obj);
       
	}

}
