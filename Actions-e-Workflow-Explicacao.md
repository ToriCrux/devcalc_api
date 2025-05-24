# Explicando a Diferença entre Workflows e Actions

## 🧩 Workflow vs Action - Entendendo a diferença

Um **workflow** é o fluxo de automação completo dentro do GitHub Actions. Ele é definido a partir de um arquivo `.yml` dentro da pasta `.github/workflows/` e descreve basicamente **quando** e **como** os jobs e etapas devem ser executados. Por exemplo, um workflow pode ser acionado a cada push na branch `main`, executando testes, builds e deploys.

Já uma **action** é uma **etapa reutilizável** dentro de um workflow. Ela pode ser uma função pronta (como "checkout do código", "configurar Java", etc.) ou personalizada, encapsulando comandos de shell, scripts ou containers.

Resumidamente:
- **Workflow** = o roteiro completo.
- **Action** = uma peça reutilizável dentro desse roteiro.

---

## ⚙️ Estrutura interna de uma Action

Uma action é definida por um arquivo chamado `action.yml` (ou `action.yaml`), que descreve:
- **name**: nome da action.
- **inputs**: parâmetros que a action pode receber.
- **outputs**: dados que ela pode gerar e passar adiante.
- **runs**: como ela será executada (por script ou container).

Exemplo simples de `action.yml`:

```yaml
name: "Minha Action Exemplo"
description: "Diz olá"
inputs:
  name:
    description: "Nome do usuário"
    required: true
    default: "Mundo"
runs:
  using: "node12"
  main: "index.js"
```

---

## 📌 Exemplo usado no Projeto

Um exemplo simples e direto de action utilizada no projeto está no workflow chamado `Primeiro Workflow`. Nele, foi criada uma action que apenas exibe uma mensagem no console:

```yaml
jobs:
  hello_job:
    runs-on: ubuntu-latest
    steps:
      - name: Exibir mensagem
        run: echo "Pipeline - Iniciado com Sucesso"
```

Neste caso, não foi usada uma action do marketplace (como `uses:`), mas sim uma action embutida personalizada, utilizando o comando `run:`. Esse tipo de step é válido dentro de workflows e executa diretamente comandos de shell no runner (neste caso, ubuntu-latest).

Mesmo não sendo chamada via `uses:`, esse `run:` é tecnicamente uma forma simples e direta de action, pois executa uma ação dentro do fluxo do workflow.