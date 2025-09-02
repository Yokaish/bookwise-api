---
title: Bookwise API
language: Java 21
framework: Spring Boot 3
database: PostgreSQL
license: MIT
author: Kauã Gomes
status: In Progress
---

# Bookwise API

Bookwise API é uma aplicação backend em Java 21, desenvolvida com Spring Boot, destinada a gerenciar livros. A API oferece funcionalidades de cadastro, listagem, atualização parcial e desativação de livros.

---

## Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Flyway (para migrações)
- Lombok
- Spring Security (SecurityFilterChain)
- Maven

---

## Funcionalidades Atuais

- **Cadastro de livros:** `POST /books`
- **Listagem paginada de livros ativos:** `GET /books`
- **Consulta de livro por ID:** `GET /books/{id}`
- **Atualização parcial de livro:** `PUT /books/{id}`
- **Desativação de livro (soft delete):** `DELETE /books/{id}`

### Observações

- Atualização parcial permite enviar apenas os campos que deseja alterar.
- Desativação altera o status do livro (`active = false`) em vez de deletar do banco.
- Paginação e ordenação nativas do Spring Data JPA.
- Tratamento global de exceções implementado via `ErrorHandler`.

---

## Estrutura de Diretórios
├─ controller/
├─ domain/Book/
├─ repository/
├─ service/
└─ infrastructure/
├─ exceptions/
└─ security/


---

## Migrações

- V1__create-table-books.sql → Criação da tabela `books`.
- V2__add-unique-constraint-to-books.sql → Adiciona restrição de unicidade `title + author`.
- V3__add-active-column.sql → Adiciona coluna `active` para soft delete.

---

## DTOs

- `BookCreateDTO` → Dados para criação.
- `BookResponseDTO` → Dados retornados para leitura.
- `BookUpdateDataDTO` → Dados permitidos para atualização parcial.
- `BookPageDTO` → Paginação personalizada.

---

## Future Features (Em Progresso)

- Autenticação JWT e roles de usuário.
- Filtros avançados de busca por título, autor e gênero.
- Upload e armazenamento de capa de livro.
- Integração com APIs externas de informações de livros.
- Testes unitários e de integração mais robustos.

---

## Rodando o Projeto

1. Configurar PostgreSQL e criar o banco `bookwise-db`.
2. Atualizar `application.properties` com usuário e senha do banco.
3. Executar a aplicação via Maven:

```bash
mvn spring-boot:run

