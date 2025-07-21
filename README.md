# API de Gerenciamento de Alunos

Sistema de gerenciamento de alunos desenvolvido em Spring Boot com banco de dados H2 e documentação Swagger.

## Descrição

Esta API REST permite o gerenciamento completo de alunos, incluindo operações de criação, leitura, atualização e exclusão (CRUD). O sistema utiliza Spring Boot 3.5.3 com Java 17, banco de dados H2 em memória e documentação automática via Swagger/OpenAPI.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**
- **Maven**

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)


### Rotas da aplicação

- **API Base URL**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console

## Configurações do Banco de Dados

O projeto utiliza H2 Database em memória com as seguintes configurações:

- **URL**: jdbc:h2:mem:testdb
- **Usuário**: sa
- **Senha**: password
- **Console H2**: http://localhost:8080/h2-console

## Endpoints da API

### Alunos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/v1/alunos` | Cadastrar novo aluno |
| GET | `/api/v1/alunos` | Listar todos os alunos |
| PUT | `/api/v1/alunos/{id}` | Atualizar aluno existente |
| DELETE | `/api/v1/alunos/{id}` | Remover aluno |

### Exemplos de Uso

#### Cadastrar Aluno

```bash
curl -X POST http://localhost:8080/api/v1/alunos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "telefone": "(11) 99999-9999",
    "dataNascimento": "1995-05-15"
  }'
```

#### Listar Alunos

```bash
curl -X GET http://localhost:8080/api/v1/alunos
```

#### Atualizar Aluno

```bash
curl -X PUT http://localhost:8080/api/v1/alunos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva Santos",
    "telefone": "(11) 99999-9999",
    "dataNascimento": "1995-05-15"
  }'
```

#### Deletar Aluno

```bash
curl -X DELETE http://localhost:8080/api/v1/alunos/1
```

## Estrutura do Projeto

```
demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/nullifidianz/demo/
│   │   │       ├── controller/
│   │   │       │   └── AlunoController.java
│   │   │       ├── domain/
│   │   │       │   ├── dto/
│   │   │       │   │   ├── AlunoRequest.java
│   │   │       │   │   ├── AlunoResponse.java
│   │   │       │   │   └── MatriculaDTO.java
│   │   │       │   ├── entity/
│   │   │       │   │   ├── Aluno.java
│   │   │       │   │   ├── DateAudit.java
│   │   │       │   │   └── Matricula.java
│   │   │       │   └── mapper/
│   │   │       │       └── AlunoMapper.java
│   │   │       ├── repository/
│   │   │       │   ├── AlunoRepository.java
│   │   │       │   └── MatriculaRepository.java
│   │   │       ├── service/
│   │   │       │   └── AlunoService.java
│   │   │       └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Documentação da API

A documentação completa da API está disponível através do Swagger UI:

- **URL**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

A documentação inclui:
- Descrição de todos os endpoints
- Exemplos de requisições e respostas
- Códigos de status HTTP
- Modelos de dados (DTOs)

## Configurações

### application.properties

O arquivo de configuração inclui:

- Configurações do banco H2
- Configurações JPA/Hibernate
- Configurações do Swagger
- Configurações de logging
- Configurações do servidor

### Logs

O sistema está configurado para exibir logs detalhados:
- Logs SQL do Hibernate
- Logs de requisições HTTP
- Logs de debug da aplicação

