package com.example.desafio3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.services.ClienteServiceI;

@SpringBootApplication
public class Desafio3Application implements CommandLineRunner {

	@Autowired
	ClienteServiceI clienteService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Cliente  cliente1 = new Cliente();
		
		cliente1.setNombre("Jose");
		cliente1.setApellidos("Fernandez");
		cliente1.setDocumentoIdentidad("12345678A");
		cliente1.setFecha("10/10/2010");
		
Cliente  cliente2 = new Cliente();
		
		cliente2.setNombre("Juan");
		cliente2.setApellidos("Fernandez");
		cliente2.setDocumentoIdentidad("43215678A");
		cliente2.setFecha("11/11/2011");
		
		
		clienteService.AddCliente(cliente1);
		clienteService.AddCliente(cliente2);
		
		
		System.out.println("Nombre cliente: " + clienteService.findbyId((long) 2).getNombre());
		System.out.println("ID cliente: " + clienteService.findByNombreandApellido(clienteService.findbyId((long) 2).getNombre(), clienteService.findbyId((long) 2).getApellidos()).getId());
		
		
		System.out.println("ID cliente eliminado: " + clienteService.RemoveCliente(cliente1));
		
	}

}
