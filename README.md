# 🎓 POO-Avançado

> Projeto Java de exemplo focado em **Programação Orientada a Objetos Avançada** com aplicação prática dos princípios SOLID.

---

## 📋 Sobre o Projeto

Projeto Java (Maven) desenvolvido como atividade educacional do programa **[Elas+ Tech da Ada](https://ada.tech/)** 💜 — **artifactId**: `POO-Avancado`.

O **Elas+ Tech** é um programa de formação tecnológica voltado para mulheres, promovendo diversidade e inclusão na área de tecnologia.

Contém exemplos práticos de:
- 📜 **Contratos** (aluguel e seguro)
- 🛒 **Pedidos** (normais e especiais)
- 🎯 Aplicação dos princípios **SOLID**

**Classe principal**: `com.ada.Main`

---

## 🏗️ Estrutura do Projeto

```
POO-Avancado/
│
├── pom.xml                          # Configuração Maven
├── README.md                        # Este arquivo
├── LICENSE                          # Licença MIT
│
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── com/ada/
    │   │   │   └── Main.java       # 🚀 Classe principal
    │   │   ├── contratos/          # 📜 Pacote de contratos
    │   │   │   ├── IContrato.java
    │   │   │   ├── Contrato.java
    │   │   │   ├── ContratoAluguel.java
    │   │   │   ├── ContratoSeguro.java
    │   │   │   └── NotificadorContratos.java
    │   │   └── pedidos/            # 🛒 Pacote de pedidos
    │   │       ├── ItemPedido.java
    │   │       ├── Pedido.java
    │   │       └── PedidoEspecial.java
    │   └── resources/
    │
    └── test/
        └── java/                    # 🧪 Testes (a implementar)
```

---

## 🎯 Princípios SOLID

Este projeto demonstra a aplicação prática dos **5 princípios SOLID** de design orientado a objetos:

### 🔹 **S** - Single Responsibility Principle (Princípio da Responsabilidade Única)
> *"Uma classe deve ter um, e somente um, motivo para mudar."*

Cada classe tem uma responsabilidade bem definida:
- `ContratoAluguel` → gerencia apenas contratos de aluguel
- `ContratoSeguro` → gerencia apenas contratos de seguro
- `NotificadorContratos` → **responsável exclusivamente por notificações** (separado da lógica de negócio dos contratos)
- `ItemPedido` → representa um item individual
- `Pedido` → gerencia a coleção de itens

**Exemplo prático**: A classe `NotificadorContratos` foi criada separadamente para gerenciar o envio de e-mails. Isso significa que:
- Se a lógica de negócio dos contratos mudar, `NotificadorContratos` não precisa mudar
- Se a forma de enviar notificações mudar (ex: adicionar SMS), apenas `NotificadorContratos` é modificado
- As classes de contrato não precisam "saber" como enviar e-mails

### 🔹 **O** - Open/Closed Principle (Princípio Aberto/Fechado)
> *"Entidades de software devem estar abertas para extensão, mas fechadas para modificação."*

As classes são extensíveis sem modificar o código existente:
- `PedidoEspecial` **estende** `Pedido` adicionando funcionalidade de desconto
- Novos tipos de contratos podem ser criados estendendo `Contrato`

### 🔹 **L** - Liskov Substitution Principle (Princípio da Substituição de Liskov)
> *"Objetos de uma superclasse devem poder ser substituídos por objetos de suas subclasses sem quebrar a aplicação."*

Você pode usar `PedidoEspecial` em qualquer lugar que espere um `Pedido`, pois mantém o contrato da classe base.

### 🔹 **I** - Interface Segregation Principle (Princípio da Segregação de Interface)
> *"Clientes não devem ser forçados a depender de interfaces que não utilizam."*

A interface `IContrato` define apenas os métodos essenciais que todo contrato deve implementar, sem forçar implementações desnecessárias.

### 🔹 **D** - Dependency Inversion Principle (Princípio da Inversão de Dependência)
> *"Dependa de abstrações, não de implementações concretas."*

O código trabalha com interfaces (`IContrato`) ao invés de classes concretas, permitindo flexibilidade e testabilidade.

---

## ⚙️ Requisitos

- ☕ **Java 21** (ou superior)
- 📦 **Maven 3.x**

---

## 🚀 Como Usar

### 📦 Compilar o Projeto

```bash
# Compilar com testes
mvn package

# Compilar sem executar testes (mais rápido)
mvn -DskipTests package
```

### ▶️ Executar o Programa

```bash
# Opção 1: Executar a partir das classes compiladas
java -cp target/classes com.ada.Main

# Opção 2: Executar a partir do JAR gerado
java -cp target/POO-Avancado-1.0-SNAPSHOT.jar com.ada.Main

# Opção 3: Usando o plugin Maven exec (após configurar no pom.xml)
mvn exec:java -Dexec.mainClass="com.ada.Main"
```


### 🧹 Limpar Build

```bash
mvn clean
```

---

## 📝 Convenções do Projeto

- 📂 Código fonte em `src/main/java`
- 📦 Pacotes seguem o padrão `com.ada.*`
- ☕ Java 21 (source/target definidos no `pom.xml`)
- 🚫 **NUNCA** commitar a pasta `target/` (está no `.gitignore`)
- ✅ Sempre validar a compilação antes de commits importantes

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📚 Recursos Adicionais

- 📖 [Princípios SOLID - Artigo](https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)
- 🎓 [Clean Code - Robert C. Martin](https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882)
- ☕ [Documentação Java 21](https://docs.oracle.com/en/java/javase/21/)
- 📦 [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

---

## 👩‍💻 Autora

<div align="center">

**Desenvolvido com ❤️ para aprendizado de POO Avançada**

Projeto parte do programa **Elas+ Tech da Ada** 💜

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Joanna-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joannabraccini/)

⭐ Se este projeto foi útil, considere dar uma estrela!

</div>

