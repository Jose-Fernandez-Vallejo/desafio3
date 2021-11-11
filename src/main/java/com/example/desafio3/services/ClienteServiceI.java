package com.example.desafio3.services;

import java.util.List;

import com.example.desafio3.entities.Cliente;

public interface ClienteServiceI {
	void AddCliente(Cliente cliente);
	List<Cliente> findAll();
	Cliente findbyId(Long id);
	Cliente findByNombreandApellido(String nombre, String apellido);
	Long RemoveCliente(Cliente cliente);
	Long RemoveClienteFromId(Long cliente);
	
	
	

}
