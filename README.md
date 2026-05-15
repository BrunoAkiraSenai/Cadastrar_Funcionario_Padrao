# Sistema de Folha de Pagamento

Sistema em Java para cadastro de funcionários e geração automatizada de folha de pagamento, desenvolvido como projeto acadêmico para demonstração de conceitos de Programação Orientada a Objetos.

## Funcionalidades

- **Cadastro de Funcionário Padrão** — Funcionário que recebe apenas o salário base
- **Cadastro de Funcionário Comissionado** — Funcionário que recebe salário base + comissão sobre vendas
- **Cadastro de Funcionário Produção** — Funcionário que recebe salário base + bônus por peça produzida
- **Geração de Folha de Pagamento** — Exibe todos os funcionários cadastrados com nome, matrícula, salário base, extras e salário final
- **Menu interativo** — Navegação por terminal com loop até o usuário encerrar
- **Validação de entradas** — Tratamento de erros para entradas inválidas, valores negativos e dados inconsistentes

## Arquitetura do Projeto

O sistema utiliza **herança** e **polimorfismo** para organizar os diferentes tipos de funcionário:

```
Funcionario (classe base)
├── FuncionarioPadrao
├── FuncionarioComissionado
└── FuncionarioProducao
```

- `Funcionario` — Classe abstrata que define os atributos comuns (matrícula, nome) e o método `calcularSalario()`
- `FuncionarioPadrao` — Retorna o salário base sem acréscimos
- `FuncionarioComissionado` — Calcula salário base + comissão (vendas * percentual / 100)
- `FuncionarioProducao` — Calcula salário base + bônus (quantidade * valor por peça)

### Cálculos

| Tipo | Fórmula |
|------|---------|
| Padrão | `salarioFinal = SALARIO_BASE` |
| Comissionado | `salarioFinal = SALARIO_BASE + (vendas * percentual / 100)` |
| Produção | `salarioFinal = SALARIO_BASE + (quantidadePecas * valorPeca)` |

## Tecnologias e Conceitos

- **Java SE** — Linguagem de programação
- **Scanner** — Entrada de dados pelo terminal
- **ArrayList** — Armazenamento dinâmico dos funcionários
- **Estruturas condicionais** — `switch` para controle do menu
- **Estruturas de repetição** — `do-while` para loop principal e `while` para validação de entradas
- **Herança** — Classes especializadas a partir de uma classe base
- **Polimorfismo** — Método `calcularSalario()` com comportamento específico por tipo
- **Encapsulamento** — Atributos protegidos com getters
- **Constantes** — Salário base definido como `public static final`

## Como Executar

### Compilar

```bash
javac -d out src/*.java
```

### Executar

```bash
java -cp out Main
```

## Estrutura do Projeto

```
src/
├── Funcionario.java              (Classe base)
├── FuncionarioPadrao.java        (Salário fixo)
├── FuncionarioComissionado.java  (Salário + comissão)
├── FuncionarioProducao.java      (Salário + produção)
└── Main.java                     (Menu e interação com usuário)
```

## Exemplo de Uso

```
========== SISTEMA DE FUNCIONÁRIOS ==========
1 - Cadastrar Funcionário Padrão
2 - Cadastrar Funcionário Comissionado
3 - Cadastrar Funcionário Produção
4 - Gerar Folha de Pagamento
0 - Sair
Escolha uma opção: 2

--- Cadastrar Funcionário Comissionado ---
Nome: João Silva
Matrícula: 101
Valor total de vendas: R$ 15000
Percentual de comissão: 5
Funcionário cadastrado com sucesso!
```

```
========== FOLHA DE PAGAMENTO ==========
Total de funcionários cadastrados: 2
------------------------------------------
Funcionário: João Silva
Matrícula: 101
Salário Base: R$ 2000.00
Extras: R$ 750.00
Salário Final: R$ 2750.00
------------------------------------------
```

## Autor

**Bruno Akira Furumori**

Projeto desenvolvido para fins acadêmicos.
