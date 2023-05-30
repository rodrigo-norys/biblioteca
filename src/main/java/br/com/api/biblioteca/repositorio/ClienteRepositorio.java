package br.com.api.biblioteca.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.biblioteca.modelo.ClienteModelo;

@Repository
public interface ClienteRepositorio extends CrudRepository<ClienteModelo, Long> {

}
