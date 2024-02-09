package br.com.perinity.gerenciamentoDeTarefas.controller;

import br.com.perinity.gerenciamentoDeTarefas.entity.TarefaEntity;
import br.com.perinity.gerenciamentoDeTarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<TarefaEntity> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaEntity> obterTarefaPorId(@PathVariable Long id) {
        return tarefaService.obterTarefaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TarefaEntity> criarTarefa(@RequestBody TarefaEntity tarefa) {
        TarefaEntity novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaEntity> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaEntity tarefa) {
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaService.deletarTarefa(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
