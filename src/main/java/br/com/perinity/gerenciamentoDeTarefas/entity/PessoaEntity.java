package br.com.perinity.gerenciamentoDeTarefas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "pessoas")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O departamento não pode estar em branco")
    private String departamento;

    @OneToMany(mappedBy = "pessoaAlocada", cascade = CascadeType.ALL)
    private List<TarefaEntity> tarefas;

    public PessoaEntity(Long id, String nome, String departamento, List<TarefaEntity> tarefas) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.tarefas = tarefas;
    }

    public PessoaEntity() {
    }

    public PessoaEntity(long l, String joão) {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<TarefaEntity> getTarefas() {
        return tarefas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setTarefas(List<TarefaEntity> tarefas) {
        this.tarefas = tarefas;
    }


}
