package br.com.perinity.gerenciamentoDeTarefas.service;

import br.com.perinity.gerenciamentoDeTarefas.entity.TarefaEntity;
import br.com.perinity.gerenciamentoDeTarefas.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    // Teste para listarTarefas
    @Test
    void listarTarefas_deveRetornarListaVazia_quandoNaoHouverTarefas() {
        // Configuração do teste
        when(tarefaRepository.findAll()).thenReturn(Collections.emptyList());

        // Execução do teste
        List<TarefaEntity> resultado = tarefaService.listarTarefas();

        // Verificação
        assertTrue(resultado.isEmpty());
    }


    @Test
    void atualizarTarefa_deveRetornarOptionalVazio_quandoTarefaNaoExistir() {
        // Configuração do teste
        Long tarefaId = 1L;
        when(tarefaRepository.findById(tarefaId)).thenReturn(Optional.empty());

        // Execução do teste
        Optional<TarefaEntity> resultado = tarefaService.atualizarTarefa(tarefaId, new TarefaEntity());

        // Verificação
        assertTrue(resultado.isEmpty());
    }

    @Test
    void deletarTarefa_deveRetornarFalse_quandoTarefaNaoExiste() {
        // Configuração do teste
        Long tarefaId = 1L;
        when(tarefaRepository.existsById(tarefaId)).thenReturn(false);

        // Execução do teste
        boolean resultado = tarefaService.deletarTarefa(tarefaId);

        // Verificação
        assertFalse(resultado);
    }
}