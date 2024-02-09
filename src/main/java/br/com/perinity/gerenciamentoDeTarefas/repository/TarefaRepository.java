package br.com.perinity.gerenciamentoDeTarefas.repository;

import br.com.perinity.gerenciamentoDeTarefas.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
