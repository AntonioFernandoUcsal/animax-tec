# Animax

O **Animax** é uma aplicação backend desenvolvida em Java (Spring Boot) para o catálogo e gerenciamento de animes. O sistema permite o cadastro de usuários e possibilita interações com as obras por meio de avaliações, comentários e listas personalizadas.

---

## 🏗️ Estrutura e Funcionalidades

A aplicação utiliza o ecossistema Spring e está dividida nas seguintes entidades principais:

*   **Anime:** Gerenciamento do catálogo principal de animes.
*   **Usuário:** Controle dos usuários da plataforma.
*   **Interações:** Sistema de `Avaliacao` e `Comentario` feito pelos usuários.
*   **Listas de Usuários:** Criação e gerenciamento de `ListaFavoritos`, `ListaPersonalizada` e `ItemLista`.

O banco de dados é configurado por meio do arquivo `application.properties` e alimentado com dados iniciais através do script `data.sql`.

---

## 💻 Pré-requisitos

Para rodar este projeto em sua máquina local, você precisará ter:
*   **Java Development Kit (JDK):** Versão compatível com a configurada no projeto (geralmente Java 11 ou 17+ para projetos Spring).
*   *Nota:* Não é obrigatório ter o Maven instalado globalmente no computador, pois o repositório já inclui o Maven Wrapper (`mvnw` e `mvnw.cmd`).

---

## 🚀 Como Executar a Aplicação

Siga o passo a passo abaixo para rodar o projeto de forma fácil e rápida:

**1. Abra o terminal**
Abra o seu terminal de preferência (PowerShell ou Prompt de Comando).

**2. Navegue até a pasta do projeto**
Pelo terminal, acesse a pasta raiz do projeto, que é o local exato onde o arquivo `mvnw.cmd` se encontra. Utilize o comando `cd` seguido do caminho da sua pasta. Exemplo:
`cd C:\Caminho\Para\Sua\Pasta\Animax`

**3. Execute o comando de inicialização**
Com o terminal na pasta correta, digite o comando abaixo e aperte Enter:
`.\mvnw.cmd spring-boot:run`

**4. Acesse a aplicação**
Aguarde o terminal carregar os arquivos e exibir a mensagem de que a aplicação iniciou (geralmente indicando "Started [NomeDaAplicacao]"). Feito isso, abra o seu navegador e acesse:
`http://localhost:8080`
