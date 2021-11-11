package com.example.desafio3.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteServiceI;

@Controller
public class ClienteController {
	      
	@Autowired
	ClienteServiceI clienteServiceI;
	
	  @RequestMapping("/index")
	  public String Index() { 
	    return "index";
	  }
	  
	  @RequestMapping("/showClientes")
	  public String showClientes(Model modelo) {
		  
		  modelo.addAttribute("clientes", clienteServiceI.findAll()); 
		  
	    return "showClientes";
	  }  
	  
	  @RequestMapping("/addCliente")
	  public String addCliente(Model modelo) {
		  
		  modelo.addAttribute("cliente", new Cliente()); 
		  
	    return "addCliente";
	  }  
	  

	  @RequestMapping(value = "/borrarCliente/{cliente}", method = RequestMethod.POST)
	  public String borrarCliente(@PathVariable String cliente) {
	      
		  clienteServiceI.RemoveClienteFromId(Long.parseLong(cliente));
		  
		  System.out.println(cliente);  
		  
	      return "redirect:/showClientes";   
	  }    
	  
	  @RequestMapping(value = "/addCliente/create", method = RequestMethod.POST)
	  public String createCliente(@ModelAttribute Cliente cliente) {
	     
		   
		  clienteServiceI.AddCliente(cliente);
		    
	      return "redirect:/showClientes";   
	  }  
	  
	  @RequestMapping(value = "/searchCliente")
	  public String searchCliente(@RequestParam(value = "nombre", required = false) String nombre,@RequestParam(value = "apellidos", required = false) String apellidos, Model model) {

		  
		  if (nombre!=null && nombre != "") { 
			  model.addAttribute("clientes" ,clienteServiceI.findByNombreandApellido(nombre, apellidos));
		}

		    
	      return "searchCliente";   
	  }  
	   
	 
	  
	  
 
} 
