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
    @GetMapping("/listarClientes")
    public Iterable<ClienteModelo> listarClientes() {
        return clienteServico.listarClientes();
    }

    // Cadastrar clientes.
    @PostMapping("/cadastrarClientes")
    public ResponseEntity<?> cadastrarClientes(@RequestBody ClienteModelo clienteModelo) {
        return clienteServico.cadastrarClientes(clienteModelo);
    }

    // Alterar clientes.
    @PostMapping("/alterarClientes")
    public ResponseEntity<?> alterarClientes(@RequestBody ClienteModelo clienteModelo) {
        return clienteServico.alterarClientes(clienteModelo);
    }

    // Remover clientes.
    @DeleteMapping("/removerClientes/{id_cliente}")
    public ResponseEntity<?> removerClientes(@PathVariable long id_cliente) {
        return clienteServico.removerClientes(id_cliente);
    }
}
