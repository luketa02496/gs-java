# WorkWell — Plataforma de Bem-Estar no Trabalho

API RESTful desenvolvida em **Spring Boot** com autenticação, controle de usuários, gerenciamento de avaliações diárias e integração com **RabbitMQ** para processamento assíncrono.

## 📌 Sobre o Projeto

O **WorkWell** é uma plataforma focada no bem-estar do colaborador dentro do ambiente de trabalho.
O sistema permite:

* Cadastro e gerenciamento de usuários
* Registro de avaliações diárias de humor, estresse e produtividade
* Envio de eventos para fila RabbitMQ
* Autenticação com Spring Security
* Organização em arquitetura limpa e escalável

---

## 🛠️ Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3+**
* Spring Web
* Spring Security
* Spring Data JPA
* Lombok
* H2 Database (ambiente de desenvolvimento)
* RabbitMQ
* Maven

---

## 📂 Estrutura do Projeto

```
src/main/java/com/lucas/work_well
│
├── controller
│   ├── AuthController.java
│   ├── UserController.java
│   └── DailyAssessmentController.java
│
├── model
│   ├── dto
│   │   ├── CreateDailyAssessmentDTO.java
│   │   └── UserDTO.java
│   └── entity
│       ├── User.java
│       └── DailyAssessment.java
│
├── repository
│   ├── UserRepository.java
│   └── DailyAssessmentRepository.java
│
├── security
│   ├── CustomUserDetails.java
│   ├── CustomUserDetailsService.java
│   └── SecurityConfig.java
│
├── service
│   ├── UserService.java
│   ├── DailyAssessmentService.java
│   └── RabbitMQProducer.java
│
└── WorkWellApplication.java
```

---

## ⚙️ Configuração do Ambiente

### **Banco de Dados (H2)**

O projeto já está configurado para rodar com H2.

Acesse o painel do H2 em:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:workwell
```

---

### 🐰 **RabbitMQ**

Instale o RabbitMQ:

Windows:

```
choco install rabbitmq
```

Linux:

```
sudo apt-get install rabbitmq-server
```

Painel de controle:

```
http://localhost:15672
```

Login padrão:

* **user:** guest
* **password:** guest

---

## ▶️ Como Rodar o Projeto

1. Clone o repositório

```
git clone https://github.com/luketa02496/gs-java.git
```

2. Entre na pasta

```
cd workwell
```

3. Instale dependências e execute

```
mvn spring-boot:run
```

---

## 🔐 Autenticação

O projeto utiliza **Spring Security** com autenticação padrão (Basic Auth).

username: lucas@workwell.com
senha 654321

---

## 📡 Endpoints Principais

### **Usuários**

| Método   | Endpoint          | Descrição         |
| -------- | ----------------- | ----------------- |
| `POST`   | `/api/users`      | Criar usuário     |
| `GET`    | `/api/users/email/{email}`      | Buscar usuario por email   |
| `GET`    | `/api/users/{id}` | Buscar usuário    |

para usar o get by email voce deve trocar o @ por %40. EX: lucas%40workwell.com

---

### **Avaliações Diárias**

| Método | Endpoint                         | Descrição              |
| ------ | -------------------------------- | ---------------------- |
| `POST` | `/api/assessments`               | Criar avaliação        |
| `GET`  | `/api/assessments/user/{userId}` | Avaliações por usuário |

---

## 📬 Mensageria — RabbitMQ

Toda nova avaliação criada envia automaticamente um evento para a fila:

```
workwell.assessments
```

---

## 🔄 Exemplo de Requisição — Criar Avaliação

### **POST /api/assessments**

```json
{
  "humor": 4,
  "estresse": 2,
  "produtividade": 5,
  "userId": 1
}
```

---

## 🧪 Testes no Postman

Coleção recomendada de testes:

* Criar usuário
* Logar com Basic Auth
* Criar avaliação
* Consultar avaliações




