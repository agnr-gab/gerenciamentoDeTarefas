package br.com.perinity.gerenciamentoDeTarefas.configs;

import br.com.perinity.gerenciamentoDeTarefas.exception.NaoLocalizadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> manipularErrosValidacao(MethodArgumentNotValidException exception) {
        List<ErroDeValidacao> erros = new ArrayList<>();
        for (FieldError fielError : exception.getFieldErrors()) {
            ErroDeValidacao erroDeValidacao = new ErroDeValidacao(fielError.getField(), fielError.getDefaultMessage());
            erros.add(erroDeValidacao);
        }
        return erros;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularEnum(HttpMessageNotReadableException exception) {

        return new MensagemDeErro("Dado inserido incorretamente, verifique e tente novamente");

    }

    @ExceptionHandler(NaoLocalizadoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro manipularDadoNaoLocalizado(HttpMessageNotReadableException exception) {

        return new MensagemDeErro(exception.getLocalizedMessage());

    }


}