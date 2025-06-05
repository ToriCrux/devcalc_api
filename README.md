# DevCalc API

[![CI Pipeline](https://github.com/ToriCrux/devcalc_api/actions/workflows/ci.yml/badge.svg)](https://github.com/ToriCrux/devcalc_api/actions/workflows/ci.yml)

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


## 📊 Observação sobre Gatilhos e Monitoramento

Para validar o monitoramento do pipeline, configurei um status badge que exibe visualmente o resultado da última execução do workflow principal. Realizei duas execuções distintas: uma automática, disparada por push na branch, e outra manual, utilizando o botão "Run workflow" na interface do GitHub Actions. 

Notei que, na execução por push, o pipeline roda automaticamente assim que há uma alteração no repositório, enquanto na execução manual posso escolher parâmetros específicos e acionar o workflow sob demanda. Essa flexibilidade permite testar cenários diferentes e controlar melhor o fluxo de CI/CD no projeto.

---

## 📚 TP3 – Teste de Performance: Controle, Segurança e Ambientes no CI/CD

Como parte do terceiro Teste de Performance da disciplina, o projeto DevCalc foi evoluído com foco em segurança, ambientes separados de deploy e novos recursos de personalização nos pipelines. Abaixo, um resumo das etapas realizadas:

### ✅ Etapa 1 – Runner Auto-Hospedado
Foi configurado um runner local no sistema operacional Windows, conectado ao repositório DevCalc, com execução de comandos básicos para validar a personalização do ambiente. 

### ✅ Etapa 2 – Uso de Variáveis e Secrets
Variáveis não sensíveis (`APP_MODE`, `SUPPORT_EMAIL`) e um segredo sensível (`PROD_TOKEN`) foram adicionados no GitHub e utilizados no workflow `variaveis-secrets.yml`. O acesso foi feito via os contextos `vars.NOME` e `secrets.NOME`.

### ✅ Etapa 3 – Contextos e Escopos de Variáveis
Demonstrou-se o comportamento de variáveis definidas em nível de workflow, job e step. Também foram exibidas informações como `github.actor` e `runner.os`, validando a sobreposição e hierarquia das variáveis de ambiente.

### ✅ Etapa 4 – GITHUB_TOKEN e Controle de Permissões
Foi criado um workflow que simula a ausência de uma variável obrigatória e, se detectado, cria automaticamente uma issue no repositório utilizando o `GITHUB_TOKEN`, com permissão configurada para `issues: write`.

### ✅ Etapa 5 – Ambientes Separados de Deploy (dev e prod)
Ambientes `dev` (liberação automática) e `prod` (com aprovação manual) foram configurados no GitHub. O workflow `deploy.yml` realiza deploy para `dev` via push na branch `dev`, e para `prod` via push na branch `main`, exigindo aprovação antes da execução.

### ✅ Etapa 6 – Nova Funcionalidade: Raiz Quadrada
Foi implementado um novo endpoint `GET /sqrt?x=valor`, que retorna a raiz quadrada do número informado. A função foi adicionada ao serviço e testada com sucesso, incluindo testes automatizados que validam entradas positivas e negativas. O pipeline de CI foi executado com todos os testes passando.

---

### ⚙️ Como Executar os Workflows do TP3

| Nome do Workflow             | Disparo                             | Caminho no Projeto                                |
|-----------------------------|--------------------------------------|---------------------------------------------------|
| `runner-local.yml`          | Manual (via "Run workflow")          | `.github/workflows/runner-local.yml`              |
| `variaveis-secrets.yml`     | Manual                               | `.github/workflows/variaveis-secrets.yml`         |
| `env-context-demo.yml`      | Manual                               | `.github/workflows/env-context-demo.yml`          |
| `alerta-variavel.yml`       | Manual                               | `.github/workflows/alerta-variavel.yml`           |
| `deploy.yml`                | Push (`dev` ou `main`)               | `.github/workflows/deploy.yml`                    |
| `ci.yml` (pipeline principal) | Push/pull request                    | `.github/workflows/ci.yml`                        |

Todos os workflows podem ser reexecutados pela aba **Actions**.
