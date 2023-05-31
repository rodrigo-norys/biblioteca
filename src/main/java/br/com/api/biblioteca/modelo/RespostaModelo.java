package br.com.api.biblioteca.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// Faz com que o Spring identifique os beans customizados de forma automática.
@Component
@Getter
@Setter
public class RespostaModelo {

    private String mensagem;
}
