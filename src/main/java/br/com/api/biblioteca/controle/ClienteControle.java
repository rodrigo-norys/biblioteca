package br.com.api.biblioteca.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.biblioteca.modelo.ClienteModelo;
import br.com.api.biblioteca.servico.ClienteServico;

@RestController
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    @GetMapping("/listar")
    public Iterable<ClienteModelo> listar() {
        return clienteServico.listar();
    }

    // Teste API
    @GetMapping("/")
    public String rota() {
        return "Api funcionando!";
    }
}
