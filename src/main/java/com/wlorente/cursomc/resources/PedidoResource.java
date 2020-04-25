package com.wlorente.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wlorente.cursomc.domain.Pedido;
import com.wlorente.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos") // nome do endpoint
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) // requisicao basica, POST seria para alterar ou inserir dados DELETE para remover
	public ResponseEntity<?> find(@PathVariable Integer id) {
       
	   Pedido obj = service.buscar(id);
       
       return ResponseEntity.ok().body(obj);
       
	}

}
