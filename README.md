# Agendador de Horários

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de agendamentos de serviços, permitindo criar, consultar, atualizar e cancelar horários de clientes com profissionais.

## ✨ Funcionalidades

- 📅 Criar novos agendamentos
- 🔍 Listar agendamentos de um dia específico
- ✏️ Atualizar um agendamento existente
- 🗑️ Cancelar (excluir) um agendamento
- ⛔ Validação automática para evitar conflito de horários no mesmo serviço

## 🛠️ Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web (REST Controllers)
- Spring Data JPA
- Lombok
- Banco de dados relacional (via JPA/Hibernate)

## 📁 Estrutura do projeto

```
src/main/java/com/javaspring/agendador_horarios/
├── controller/
│   └── AgendamentoController.java
├── services/
│   └── AgendamentoService.java
└── infrastructure/
    ├── entity/
    │   └── AgendamentoEntity.java
    └── repository/
        └── AgendamentoRepository.java
```

## 🔗 Endpoints da API

Base URL: `/agendamentos`

### Criar agendamento
```http
POST /agendamentos
```
**Body (JSON):**
```json
{
  "servico": "Corte de cabelo",
  "profissional": "João",
  "cliente": "Maria",
  "telefone": "31999999999",
  "dataHoraAgendamento": "2026-08-25T14:00:00"
}
```
Retorna `202 Accepted` com o agendamento criado. Caso já exista um agendamento para o mesmo serviço dentro do intervalo de 1 hora, retorna erro informando que o horário já está preenchido.

### Listar agendamentos por dia
```http
GET /agendamentos?data=2026-08-25
```
Retorna `200 OK` com a lista de agendamentos do dia informado.

### Atualizar agendamento
```http
PUT /agendamentos?cliente=Maria&dataHoraAgendamento=2026-08-25T14:00:00
```
**Body (JSON):** dados atualizados do agendamento.

Retorna `202 Accepted` com o agendamento atualizado. Caso não exista um agendamento correspondente, retorna erro.

### Excluir agendamento
```http
DELETE /agendamentos?cliente=Maria&dataHoraAgendamento=2026-08-25T14:00:00
```
Retorna `204 No Content` quando excluído com sucesso.

## ⚙️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven
- Banco de dados configurado (application.properties/yml)

### Passos

```bash
# Clone o repositório
git clone <url-do-repositorio>
cd agendador-horarios

# Rode o projeto
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## 📌 Regras de negócio

- Não é possível agendar dois horários para o **mesmo serviço** com menos de 1 hora de diferença entre eles.
- A atualização e exclusão de agendamentos são feitas com base na combinação de **cliente** e **data/hora do agendamento**.

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.

## 📄 Licença

Este projeto está sob a licença MIT.
