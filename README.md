# DevCalc API

## 📌 Objetivo
A DevCalc é uma API REST, desenvolvida em Java, que disponibiliza operações matemáticas simples.
Essa API, faz parte de um exercício para prática de CI/CD com o GitHub Actions.

## 🛠️ Tecnologias e Ferramentas utilizadas no desenvolvimento
- Java 21
- Maven
- Javalin (framework leve para criação de APIs REST)
- GitHub Actions (CI/CD)

## 🚀 Como Executar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/ToriCrux/devcalc_api.git

## 🧪 Diagnóstico e Correção de Falha no Pipeline

Durante a atividade prática de depuração, provoquei uma falha intencional no job de testes automatizados, alterando o comando correto `mvn test` para `mvn tset`. 

Após fazer o push da alteração, acessei a aba **Actions** no GitHub e identifiquei que o job havia falhado. Cliquei nesse pipeline com erro e através da interface de logs, encontrei a mensagem de erro informando que "tset" não era um comando reconhecido pelo Maven. 

Com isso, reverti a alteração para o comando correto e confirmei a correção ao observar que o pipeline foi executado com sucesso na nova tentativa.
