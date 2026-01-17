# 💜 POO Avançado

### Aprenda SOLID na prática com Java!

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat-square)](LICENSE)

> 🚀 Projeto desenvolvido no programa **[Elas+ Tech da Ada](https://ada.tech/)**

---

## 🌟 O que é isso?

Este é um projeto de estudo que mostra como aplicar os **princípios SOLID** em um sistema Java real. Aqui você vai encontrar exemplos práticos de:

✅ **Sistema de Contratos** - Gerenciamento de contratos com ações (aceitar, recusar, cancelar) e rescisão  
✅ **Processamento de Pagamentos** - Pagamentos via boleto e cartão com parcelamento  
✅ **Persistência de Dados** - Padrão Repository com implementações para arquivo e banco de dados  
✅ **Injeção de Dependência** - `ContratoService` recebe o repositório por construtor  
✅ **Tratamento de Exceções** - Validação de contratos com `ContratoInvalidoException` customizada  
✅ **Gestão de Pessoas** - Cadastro e gerenciamento de pessoas  
✅ **Sistema de Pedidos** - Pedidos comuns e especiais com descontos  
✅ **Enums** - Ações de contratos tipadas e seguras  
✅ **Interfaces Segregadas** - `Pagamento` e `Parcelavel` separadas (Interface Segregation na prática!)  
✅ **Classe Abstrata** - `Contrato` define o contrato base com método abstrato `executarAcao()`

---

## ✨ Destaques do Projeto

### 🎬 Enums com Ações de Contratos
Usa `enum Acao` para definir ações como **Aceitar**, **Recusar** e **Cancelar** contratos de forma tipada e segura.

### 💳 Interface Segregation na Prática
Interfaces separadas: `Pagamento` (todos implementam) e `Parcelavel` (só quem precisa). Cartão de crédito implementa ambas, boleto só `Pagamento`.

### 🔄 Polimorfismo e Abstração
Classe abstrata `Contrato` define o método abstrato `executarAcao(Acao)` que cada tipo de contrato implementa de forma única. `ContratoSeguro` aceita/recusa com uma lógica, `ContratoTrabalho` com outra. `ContratoTrabalho` ainda tem seu método específico `rescindirPorJustaCausa()`. Polimorfismo na veia!

### 📦 Lombok
Usa Lombok para reduzir boilerplate com `@Getter`, `@Setter`, `@AllArgsConstructor`.

### 💾 Padrão Repository + Dependency Inversion
**Interface** `ContratoRepository` define o contrato. **Implementações** `ContratoRepositoryArquivo` e `ContratoRepositoryBD` salvam em arquivo ou banco de dados. `ContratoService` não sabe qual implementação está usando - ele só depende da abstração! Troca de arquivo pra BD? Só muda a injeção no construtor. SOLID no seu melhor! 🚀

### ⚠️ Tratamento de Exceções Customizadas
`ContratoInvalidoException` valida contratos antes de salvar. O `ContratoService` usa try-catch para capturar e tratar erros de forma elegante, impedindo que contratos nulos sejam salvos. Validação robusta e mensagens de erro claras!

### 🎨 Classes Abstratas em Ação
`Contrato` é uma classe abstrata que define a estrutura base para todos os tipos de contratos. Cada contrato (Aluguel, Seguro, Trabalho, Fornecedor) implementa o método abstrato `executarAcao(Acao)` do seu jeito. Reutilização de código + flexibilidade!

---

## 🎯 O que é SOLID?

**SOLID** são 5 princípios que deixam seu código mais limpo, organizado e fácil de manter. É tipo as regras de ouro da programação orientada a objetos!

### 💡 Os 5 Princípios Explicados Simples

#### **S** - Single Responsibility
Cada classe faz uma coisa só. `ContratoAluguel` cuida de aluguéis, `NotificadorContratos` cuida de notificações. `PagamentoCartao` processa pagamentos, não gerencia contratos!

#### **O** - Open/Closed
Pode estender, mas não modifica. Criou `PedidoEspecial`? Estende `Pedido` sem bagunçar o código original. Novo tipo de contrato? Herda de `Contrato` e pronto!

#### **L** - Liskov Substitution
Se funciona com a classe pai, funciona com a filha. Use `ContratoTrabalho` onde aceita `Contrato` sem medo! Método `executarAcao()` funciona em qualquer contrato.

#### **I** - Interface Segregation
Interfaces pequenas e focadas. `Pagamento` tem só `processarPagamento()`. `Parcelavel` tem só `parcelarPagamento()`. Boleto não parcela? Não precisa implementar `Parcelavel`!

#### **D** - Dependency Inversion
Dependa de abstrações (interfaces), não de classes concretas. `ContratoService` depende de `ContratoRepository` (interface), não de `ContratoRepositoryBD` ou `ContratoRepositoryArquivo`. Quer mudar de arquivo pra banco? Só muda a injeção! Código desacoplado e flexível!

---

## 🚀 Como usar

**Você precisa de:**
- Java 21+ instalado
- Maven 3.x

**Rodar o projeto:**

```bash
mvn clean package
java -cp target/classes com.ada.Main
```

É isso! 🎉

---

## 📄 Licença

MIT License - use, estude e aprenda à vontade! 💙

---

## 💜 Feito por

**Joanna Braccini** no programa Elas+ Tech da Ada

[![LinkedIn](https://img.shields.io/badge/Conecte--se_comigo!-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joannabraccini/)

---

⭐ Gostou? Deixa uma estrela! • 🐛 Achou um bug? Abre uma issue! • 💡 Tem sugestões? Fala comigo!

