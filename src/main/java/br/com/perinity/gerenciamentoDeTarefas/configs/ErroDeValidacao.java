package br.com.perinity.gerenciamentoDeTarefas.configs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErroDeValidacao {
    private String campo;
    private String mensagem;

//    public ErroDeValidacao(String field, String defaultMessage) {
//    }
}
