package br.com.perinity.gerenciamentoDeTarefas.service;

import br.com.perinity.gerenciamentoDeTarefas.entity.TarefaEntity;
import br.com.perinity.gerenciamentoDeTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaEntity> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<TarefaEntity> obterTarefaPorId(Long tarefaId) {
        return tarefaRepository.findById(tarefaId);
    }

    public TarefaEntity criarTarefa(TarefaEntity tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Optional<TarefaEntity> atualizarTarefa(Long tarefaId, TarefaEntity tarefa) {
        return tarefaRepository.findById(tarefaId)
                .map(tarefaExistente -> {
                    tarefa.setId(tarefaId);
                    return tarefaRepository.save(tarefa);
                });
    }

    public boolean deletarTarefa(Long tarefaId) {
        if (tarefaRepository.existsById(tarefaId)) {
            tarefaRepository.deleteById(tarefaId);
            return true;
        }
        return false;
    }
}

