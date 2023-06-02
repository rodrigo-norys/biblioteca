package br.com.api.biblioteca.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.biblioteca.modelo.ClienteModelo;
import br.com.api.biblioteca.servico.ClienteServico;

@RestController
@CrossOrigin(origins = "*")
public class ClienteControle {

    @Autowired
    private ClienteServico clienteServico;

    // Teste API
    @GetMapping("/")
    public String rota() {
        return "Api funcionando!";
    }

    // Listar clientes.
    @GetMapping("/listar")
    public Iterable<ClienteModelo> listar() {
        return clienteServico.listar();
    }

    // Cadastrar clientes.
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteModelo clienteModelo) {
        return clienteServico.cadastrar(clienteModelo);
    }

    // Alterar clientes.
    @PostMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ClienteModelo clienteModelo) {
        return clienteServico.alterar(clienteModelo);
    }

    // Remover clientes.
    @DeleteMapping("/remover/{id_cliente}")
    public ResponseEntity<?> remover(@PathVariable long id_cliente) {
        return clienteServico.remover(id_cliente);
    }
}
