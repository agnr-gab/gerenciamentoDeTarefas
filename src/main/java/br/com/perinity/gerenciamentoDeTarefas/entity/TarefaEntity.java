package br.com.perinity.gerenciamentoDeTarefas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class TarefaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O título não pode estar em branco")
    private String titulo;

    private String descricao;

    @NotNull(message = "O prazo não pode estar em branco")
    private LocalDate prazo;

    @NotBlank(message = "O departamento não pode estar em branco")
    private String departamento;

    private int duracao;

    private boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaEntity pessoaAlocada;

    public TarefaEntity() {
    }

    public TarefaEntity(Long id, String titulo, String descricao, LocalDate prazo, String departamento, int duracao,
                        boolean finalizado, PessoaEntity pessoaAlocada) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.departamento = departamento;
        this.duracao = duracao;
        this.finalizado = finalizado;
        this.pessoaAlocada = pessoaAlocada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public PessoaEntity getPessoaAlocada() {
        return pessoaAlocada;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public void setPessoaAlocada(PessoaEntity pessoaAlocada) {
        this.pessoaAlocada = pessoaAlocada;
    }
}
