package br.com.api.biblioteca.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.api.biblioteca.modelo.ClienteModelo;

// Repositório
public interface ClienteRepositorio extends CrudRepository<ClienteModelo, Long> {

}
