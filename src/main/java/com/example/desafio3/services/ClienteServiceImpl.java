package com.example.desafio3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio3.entities.Cliente;
import com.example.desafio3.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteServiceI {

	@Autowired
	ClienteRepository repository;
	
	
	@Override
	public Cliente findbyId(Long id) {
		return repository.findByid(id);
	}

	@Override
	public List<Cliente> findByNombreandApellido(String nombre, String apellido) {

		return repository.findByNombreAndApellidos(nombre, apellido);
	}

	@Override
	public void AddCliente(Cliente cliente) {
		
		repository.save(cliente);
	}

	@Override
	public Long RemoveCliente(Cliente cliente) {
		 repository.delete(cliente);
		 return cliente.getId();
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public Long RemoveClienteFromId(Long cliente) {
		
		repository.deleteById(cliente);
		// TODO Auto-generated method stub
		return cliente;
	}

}
