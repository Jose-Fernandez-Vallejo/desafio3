package com.example.desafio3;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

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
		 
		LocalDate local = LocalDate.of(2010, 10, 10+1);
		Date fecha = Date.from(local.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Cliente  cliente1 = new Cliente();
		
		cliente1.setNombre("Jose");
		cliente1.setApellidos("Fernandez");
		cliente1.setDocumentoIdentidad("12345678A");
		cliente1.setFecha("1999-10-10");
		
Cliente  cliente2 = new Cliente();
		
		cliente2.setNombre("Juan");
		cliente2.setApellidos("Fernandez");
		cliente2.setDocumentoIdentidad("43215678A");
		cliente2.setFecha("1999-10-10");
		
		
		clienteService.AddCliente(cliente1);
		clienteService.AddCliente(cliente2);
		
		
		System.out.println("Nombre cliente: " + clienteService.findbyId((long) 2).getNombre());
		
		for (Cliente cliente : clienteService.findAll()) {
			
			System.out.println("Nombre cliente: " + cliente.getNombre());
			
		}
	 
	}

}
