package com.example.desafio3.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.desafio3.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findByid(Long id);
	Cliente findByNombreAndApellidos(String nombre, String apellido);
}
