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

**1. Navegue até a pasta raiz do projeto**
Abra o seu terminal (ou prompt de comando) e entre no diretório onde os arquivos `pom.xml` e `mvnw` estão localizados.
```bash
cd Animax2/Animax