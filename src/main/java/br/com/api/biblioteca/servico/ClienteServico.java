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

    // Método para listar
    public Iterable<ClienteModelo> listar() {
        return clienteRepositorio.findAll();
    }

    // Método para cadastrar
    public ResponseEntity<?> cadastrar(ClienteModelo clienteModelo) {
        if (clienteModelo.getNome().equals("")) {
            respostaModelo.setMensagem("O campo nome precisa ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (clienteModelo.getSobrenome().equals("")) {
            respostaModelo.setMensagem("O campo sobrenome precisa ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (clienteModelo.getTelefone() == 0) {
            respostaModelo.setMensagem("O campo telefone precisa ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (clienteModelo.getBairro().equals("")) {
            respostaModelo.setMensagem("O campo bairro precisa ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (clienteModelo.getRua().equals("")) {
            respostaModelo.setMensagem("O nome rua precisa ser preenchido!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<ClienteModelo>(clienteRepositorio.save(clienteModelo), HttpStatus.CREATED);
        }
    }
}
