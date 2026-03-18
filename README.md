# 🧪 API Test Automation - Seu Barriga (Rest Assured)

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white"/>
  <img src="https://img.shields.io/badge/RestAssured-16A085?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
  <img src="https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge"/>
</p>

---

# 📌 Sobre o Projeto

Este projeto é uma **automação de testes de API REST** desenvolvida utilizando **Java + Rest Assured**.

O objetivo principal é **praticar automação de APIs, validações de regras de negócio e boas práticas de organização de testes**, simulando cenários reais da aplicação **Seu Barriga**.

O projeto também demonstra conceitos importantes como:

* Autenticação via **JWT**
* Reutilização de configuração com **BaseTest**
* Uso de **variáveis de ambiente (.env)**
* Validações de tempo de resposta

---

# 🎯 Objetivos do Projeto

Este projeto foi criado com os seguintes objetivos:

* Praticar **automação de testes de API**
* Aplicar **boas práticas com Rest Assured**
* Implementar **reutilização de código**
* Criar uma **estrutura organizada de automação**
* Trabalhar com **autenticação e tokens**
* Validar **regras de negócio via API**

---

# 🧪 Cenários de Teste Automatizados

## CT01 -- Acesso sem autenticação

Fluxo testado:

1. Realizar requisição sem token
2. Acessar endpoint protegido `/contas`
3. Validar retorno **401 Unauthorized**

---

## CT02 -- Criação de Conta

Fluxo testado:

1. Realizar login na API
2. Obter token JWT
3. Enviar requisição `POST /contas`
4. Validar criação com status **201 Created**

---

## CT03 -- Alteração de Conta

Fluxo testado:

1. Realizar login
2. Utilizar token de autenticação
3. Enviar requisição `PUT /contas/{id}`
4. Validar atualização com status **200 OK**

---

# 🧩 Estrutura do Projeto

```
seu-barriga-api-rest-assured-test-automation
│
├── src
│   └── main
│       └── java
│           └── rest
│               ├── core
│               │   ├── BaseTest.java
│               │   └── Constantes.java
│               │
│               └── tests
│                   └── BarrigaTest.java
│
├── .env
├── pom.xml
├── README.md
└── .gitignore
```

### 🔹 BaseTest.java

Responsável por:

* Configuração global do Rest Assured
* Definição de:

    * Base URL
    * Porta
    * Content-Type
    * Timeout
* Configuração de logs em caso de falha

---

### 🔹 Constantes.java

Centraliza:

* URL da API
* Porta
* Tipo de conteúdo (JSON)
* Tempo máximo de resposta

---

### 🔹 BarrigaTest.java

Contém os testes automatizados:

* Login e geração de token
* Testes de autorização
* Testes de CRUD na API

---

# 🛠️ Tecnologias Utilizadas

* Java
* Rest Assured
* JUnit 5
* Maven
* Dotenv
* Hamcrest
* Git
* GitHub

---

# 📋 Pré-requisitos

Para executar o projeto é necessário ter instalado:

* Java 11+
* Maven
* Git

---

# ⚙️ Configuração

Crie um arquivo `.env` na raiz do projeto com suas credenciais:

```
USER_EMAIL=seu_email
USER_PASSWORD=sua_senha
```

---

# ▶️ Executando os Testes

Execute todos os testes com o Maven:

```bash
mvn clean test
```

---

# 🔐 Autenticação

A autenticação é realizada via endpoint:

```
POST /signin
```

O token JWT é:

* Gerado automaticamente antes dos testes (`@BeforeEach`)
* Utilizado nos headers das requisições protegidas

Exemplo de header:

```
Authorization: JWT {token}
```

---

# 📊 Validações realizadas

Os testes validam:

* Status Code
* Autorização de acesso
* Regras de negócio
* Tempo de resposta da API

---

# 🚀 Próximas Melhorias

Algumas melhorias planejadas para o projeto:

* 🔄 Criar massa de dados dinâmica (setup/teardown)
* 🧱 Implementar camada de services (Service Layer)
* 📊 Adicionar relatórios (Allure Reports)
* 🔁 Encadear cenários completos (fluxo E2E via API)
* 🚀 Integração com CI/CD (GitHub Actions)
* 🧪 Testes parametrizados

---

# 👨‍💻 Autor

Henrique Soares

---

# 📣 Sobre o projeto

Este projeto foi desenvolvido com foco em estudos de **automação de testes de API**, simulando práticas utilizadas no mercado de QA.

---
