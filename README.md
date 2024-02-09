## API de Gerenciamento de Tarefas

### Descrição

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de tarefas, com foco na usabilidade pela equipe de front.

### Tecnologias

-   Linguagem: Java
-   Framework: Spring Boot
-   Banco de dados: PostgreSQL
-   Testes: JUnit

### Funcionalidades

**Gerenciamento de Pessoas:**

-   Cadastro, consulta, atualização e exclusão de pessoas.
-   Atribuição de tarefas a pessoas.

**Gerenciamento de Tarefas:**

-   Cadastro, consulta, atualização e exclusão de tarefas.
-   Definição de título, descrição, prazo, departamento, duração e pessoa alocada para cada tarefa.
-   Controle de finalização de tarefas.

**Filtros e Ordenação:**

-   Possibilidade de filtrar tarefas por departamento, pessoa alocada e status de finalização.
-   Ordenação de tarefas por diferentes critérios, como prazo, título e departamento.

### Endereços da API

**Pessoas:**

-   `/api/pessoas`
-   `/api/pessoas/{id}`

**Tarefas:**

-   `/api/tarefas`
-   `/api/tarefas/{id}`
-   `/api/tarefas/filtrar?departamento={departamento}&pessoaAlocada={pessoaAlocada}&finalizada={finalizada}`

### Modelo das Requisições

**Exemplo de requisição:**

```
GET /api/tarefas/filtrar?departamento=TI&pessoaAlocada=João&finalizada=false

```

**Parâmetros:**

-   `departamento`: departamento da tarefa (opcional)
-   `pessoaAlocada`: pessoa alocada na tarefa (opcional)
-   `finalizada`: indica se a tarefa está finalizada (opcional)

**Corpo da requisição:**

-   Nenhum

### Modelo das Respostas

**Exemplo de resposta:**

JSON

```
[
  {
    "id": 1,
    "titulo": "Criar nova interface de usuário",
    "descricao": "Desenvolver nova interface para o sistema de gerenciamento de tarefas.",
    "prazo": "2024-02-10",
    "departamento": "TI",
    "duracao": 8,
    "pessoaAlocada": "João",
    "finalizada": false
  },
  {
    "id": 2,
    "titulo": "Implementar nova funcionalidade",
    "descricao": "Adicionar nova funcionalidade de filtro de tarefas por departamento.",
    "prazo": "2024-02-15",
    "departamento": "TI",
    "duracao": 4,
    "pessoaAlocada": "Maria",
    "finalizada": false
  }
]

```




**Atributos:**

-   `id`: identificador único da tarefa
-   `titulo`: título da tarefa
-   `descricao`: descrição da tarefa
-   `prazo`: data limite para a conclusão da tarefa
-   `departamento`: departamento responsável pela tarefa
-   `duracao`: estimativa de tempo para a conclusão da tarefa (em horas)
-   `pessoaAlocada`: pessoa responsável pela execução da tarefa
-   `finalizada`: indica se a tarefa foi concluída