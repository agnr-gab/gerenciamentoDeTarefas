package br.com.perinity.gerenciamentoDeTarefas.repository;

import br.com.perinity.gerenciamentoDeTarefas.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {


}
