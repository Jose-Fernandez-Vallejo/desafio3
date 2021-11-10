package com.example.desafio3.services;

import com.example.desafio3.entities.Cliente;

public interface ClienteServiceI {
	void AddCliente(Cliente cliente);
	Cliente findbyId(Long id);
	Cliente findByNombreandApellido(String nombre, String apellido);
	Long RemoveCliente(Cliente cliente);
	
	

}
