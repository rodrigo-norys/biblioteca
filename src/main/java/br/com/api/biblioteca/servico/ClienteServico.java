package br.com.api.biblioteca.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.modelo.ClienteModelo;
import br.com.api.biblioteca.modelo.RespostaModelo;
import br.com.api.biblioteca.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    // Método para listar clientes.
    public Iterable<ClienteModelo> listarClientes() {
        return clienteRepositorio.findAll();
    }

    // Verifica se o valor retornado pode virar um INT.
    private boolean seNumerico(String telefone) {
        try {
            Integer.parseInt(telefone);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    // Método para cadastrar clientes.
    public ResponseEntity<?> cadastrarClientes(ClienteModelo clienteModelo) {
        if (clienteModelo.getNome().equals("")) {
            respostaModelo.setMensagem("O nome precisa ser preenchido!");
        } else if (clienteModelo.getSobrenome().equals("")) {
            respostaModelo.setMensagem("O sobrenome precisa ser preenchido!");
        } else if (clienteModelo.getTelefone() == "" || !seNumerico(clienteModelo.getTelefone())) {
            respostaModelo.setMensagem("Preencha o telefone corretamente!");
        } else if (clienteModelo.getBairro().equals("")) {
            respostaModelo.setMensagem("O bairro precisa ser preenchido!");
        } else if (clienteModelo.getRua().equals("")) {
            respostaModelo.setMensagem("A rua precisa ser preenchida!");
        } else {
            return new ResponseEntity<ClienteModelo>(clienteRepositorio.save(clienteModelo), HttpStatus.CREATED);
        }
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
    }

    // Método para alterar clientes.
    public ResponseEntity<?> alterarClientes(ClienteModelo clienteModelo) {
        if (clienteModelo.getNome().equals("")) {
            respostaModelo.setMensagem("O nome precisa ser preenchido!");
        } else if (clienteModelo.getSobrenome().equals("")) {
            respostaModelo.setMensagem("O sobrenome precisa ser preenchido!");
        } else if (clienteModelo.getTelefone() == "" || !seNumerico(clienteModelo.getTelefone())) {
            respostaModelo.setMensagem("O telefone precisa ser preenchido apenas com números!");
        } else if (clienteModelo.getBairro().equals("")) {
            respostaModelo.setMensagem("O bairro precisa ser preenchido!");
        } else if (clienteModelo.getRua().equals("")) {
            respostaModelo.setMensagem("A rua precisa ser preenchida!");
        } else {
            return new ResponseEntity<ClienteModelo>(clienteRepositorio.save(clienteModelo), HttpStatus.CREATED);
        }
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
    }

    // Método para remover clientes.
    public ResponseEntity<?> removerClientes(long id_cliente) {
        if (clienteRepositorio.existsById(id_cliente)) {
            clienteRepositorio.deleteById(id_cliente);
            respostaModelo.setMensagem("O cliente foi removido com sucesso!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
        } else {
            respostaModelo.setMensagem("É necessário que informe um ID válido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }
    }
}
