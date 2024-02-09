package br.com.perinity.gerenciamentoDeTarefas.controller;

import br.com.perinity.gerenciamentoDeTarefas.entity.PessoaEntity;
import br.com.perinity.gerenciamentoDeTarefas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaEntity> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaEntity> obterPessoaPorId(@PathVariable Long id) {
        PessoaEntity pessoa = pessoaService.obterPessoaPorId(id);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PessoaEntity> criarPessoa(@RequestBody PessoaEntity pessoa) {
        PessoaEntity novaPessoa = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<PessoaEntity>> atualizarPessoa(@PathVariable Long id, @RequestBody PessoaEntity pessoa) {
        Optional<PessoaEntity> pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
        if (pessoaAtualizada != null) {
            return ResponseEntity.ok(pessoaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        if (pessoaService.deletarPessoa(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}