# ProcessoSeletivo

Projeto criado para praticar estruturas de repetição (`for`, `while`, `do-while`), estruturas condicionais e manipulação de arrays em Java, simulando um processo seletivo de candidatos.

## 💡 Sobre o projeto

A classe `ProcessoSeletivo` simula três etapas de um processo de contratação:

1. **Tentativa de contato** — para cada candidato da lista, o programa simula até 3 tentativas de ligação, parando assim que o contato é "atendido".
2. **Seleção por salário pretendido** — percorre os candidatos e seleciona até 5 deles, comparando o salário pretendido (gerado aleatoriamente) com um salário base fixo.
3. **Impressão da lista** — exibe os candidatos numerados (por índice) e também através de um laço `for-each`.

Todo o comportamento "aleatório" (se o candidato atende a ligação, e qual salário pretende) é simulado com as classes `Random` e `ThreadLocalRandom`, apenas para fins didáticos.

## 🗂️ Estrutura do projeto

```
ProcessoSeletivo/
├── src/
│   └── candidatura/
│       └── ProcessoSeletivo.java
└── javadoc/          # documentação gerada em HTML
    └── index.html
```

## ▶️ Como executar

> ⚠️ **Atenção:** o método `main` está declarado como `static void main(String[] args)`, sem o modificador `public`. Nesse formato a JVM não reconhece o método como ponto de entrada e a execução falha com `Error: Main method not found`. Adicione `public` antes de `static` para rodar o programa:
> ```java
> public static void main(String[] args) { ... }
> ```

Com o JDK instalado, a partir da raiz do projeto:

```bash
javac -d bin src/candidatura/ProcessoSeletivo.java
java -cp bin candidatura.ProcessoSeletivo
```

## 📖 Documentação (Javadoc)

O código está documentado com comentários Javadoc na classe e em todos os métodos. Para gerar (ou regenerar) o HTML navegável:

```bash
javadoc -d javadoc -sourcepath src -subpackages candidatura
```

Depois, é só abrir `javadoc/index.html` no navegador.

## 🧩 Métodos principais

| Método | Descrição |
|---|---|
| `main(String[] args)` | Ponto de entrada; percorre os candidatos e tenta contato com cada um. |
| `entrandoEmContato(String candidato)` | Realiza até 3 tentativas de contato com um candidato. |
| `atender()` | Simula, de forma aleatória, se a ligação foi atendida. |
| `imprimirSelecionados()` | Imprime a lista de candidatos por índice e via `for-each`. |
| `selecaoCandidatos()` | Seleciona até 5 candidatos com salário pretendido dentro do limite. |
| `valorPretendido()` | Simula o salário pretendido por um candidato (entre R$ 1800 e R$ 2200). |
| `analisarCandidato(double salarioPretendido)` | Compara o salário pretendido com o salário base e sugere uma ação. |

## 📚 Conceitos praticados

- Declaração e manipulação de arrays (`String[]`)
- Estruturas de repetição: `for`, `for-each`, `while` e `do-while`
- Estruturas condicionais: `if / else if / else`
- Geração de números aleatórios com `Random` e `ThreadLocalRandom`
- Documentação de código com Javadoc

## 🚀 Próximos passos (sugestões de evolução)

- Corrigir o modificador de acesso do `main` (`public static void main`)
- Corrigir o typo `tentaivasRealizadas` → `tentativasRealizadas`
- Extrair a lista de candidatos para um único local (hoje ela é repetida em `main`, `imprimirSelecionados` e `selecaoCandidatos`)
- Transformar `Candidato` em uma classe própria (nome + salário pretendido), como exercício de POO
- Escrever testes unitários para os métodos de seleção e análise