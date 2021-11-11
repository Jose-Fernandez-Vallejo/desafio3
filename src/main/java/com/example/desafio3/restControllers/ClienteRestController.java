package com.example.desafio3.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteServiceI;

@RestController
public class ClienteRestController {
	
    
@Autowired
ClienteServiceI clienteServiceI;
	
	  @RequestMapping("/restShowAll")
	  public @ResponseBody List<Cliente> showClientes(Model modelo) {
		  
		  return clienteServiceI.findAll();
	     
	  }
	  
	  @RequestMapping("/restDelete/{id}")
	  public void showClientes(@PathVariable Long id) {
		  
		  clienteServiceI.RemoveClienteFromId(id);
		  
	     
	  }

}
