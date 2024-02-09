package br.com.perinity.gerenciamentoDeTarefas.service;

import br.com.perinity.gerenciamentoDeTarefas.entity.PessoaEntity;
import br.com.perinity.gerenciamentoDeTarefas.exception.PessoaNaoEncontradaException;
import br.com.perinity.gerenciamentoDeTarefas.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private PessoaEntity pessoaMock;

    @BeforeEach
    public void setUp() {
        pessoaMock = new PessoaEntity(1L, "Nome");
    }

    @Test
    @DisplayName("Deve Listar todas as Pessoas")
    public void listarPessoasTest() {
        List<PessoaEntity> pessoasMock = new ArrayList<>();
        pessoasMock.add(pessoaMock);

        when(pessoaRepository.findAll()).thenReturn(pessoasMock);

        List<PessoaEntity> result = pessoaService.listarPessoas();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(pessoaMock, result.get(0));
    }

    @Test
    @DisplayName("Deve Obter uma Pessoa pelo ID")
    public void obterPessoaPorIdTest() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(pessoaMock));

        PessoaEntity result = pessoaService.obterPessoaPorId(1L);

        assertNotNull(result);
        assertEquals(pessoaMock, result);
    }



    @Test
    @DisplayName("Deve Criar uma Nova Pessoa")
    @Transactional
    public void criarPessoaTest() {
        when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(pessoaMock);

        PessoaEntity result = pessoaService.criarPessoa(pessoaMock);

        assertNotNull(result);
        assertEquals(pessoaMock, result);
        verify(pessoaRepository, times(1)).save(pessoaMock);
    }






}
