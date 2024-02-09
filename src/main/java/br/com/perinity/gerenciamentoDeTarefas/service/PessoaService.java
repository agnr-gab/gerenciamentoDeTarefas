package br.com.perinity.gerenciamentoDeTarefas.service;

import br.com.perinity.gerenciamentoDeTarefas.entity.PessoaEntity;
import br.com.perinity.gerenciamentoDeTarefas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaEntity> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public PessoaEntity obterPessoaPorId(Long pessoaId) {
        return pessoaRepository.findById(pessoaId).orElse(null);
    }

    public PessoaEntity criarPessoa(PessoaEntity pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<PessoaEntity> atualizarPessoa(Long pessoaId, PessoaEntity pessoa) {
        return pessoaRepository.findById(pessoaId)
                .map(pessoaExistente -> {
                    pessoa.setId(pessoaId);
                    return pessoaRepository.save(pessoa);
                });
    }

    public boolean deletarPessoa(Long pessoaId) {
        if (pessoaRepository.existsById(pessoaId)) {
            pessoaRepository.deleteById(pessoaId);
            return true;
        }
        return false;
    }
}

