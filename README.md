# 🎓 POO Avançado

> Aprendendo POO de verdade aplicando os princípios SOLID! 💜

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat-square)](LICENSE)

Projeto desenvolvido no programa **[Elas+ Tech da Ada](https://ada.tech/)** 🚀

---

## 💡 Sobre

Um projeto prático de Java que demonstra os **5 princípios SOLID** através de um sistema real com:

- 📜 Contratos (aluguel, seguro, fornecedor, trabalho)
- 💳 Pagamentos (boleto e cartão)
- 👥 Gerenciamento de pessoas
- 🛒 Sistema de pedidos
- 📧 Notificações

---

## 🎯 Princípios SOLID

**SOLID** é um acrônimo para 5 princípios que tornam o código mais limpo, flexível e fácil de manter.

---

### 🔹 S - Single Responsibility (Responsabilidade Única)

> Uma classe, uma responsabilidade!

**No projeto:** 
- `ContratoAluguel` cuida só de contratos de aluguel
- `NotificadorContratos` cuida só de enviar notificações
- Se algo mudar nas notificações, só mexo no `NotificadorContratos`! ✨

---

### 🔹 O - Open/Closed (Aberto/Fechado)

> Aberto para extensão, fechado para modificação.

**No projeto:**
- `PedidoEspecial` **estende** `Pedido` e adiciona desconto
- Não preciso mexer no código original pra adicionar features! 🚀

---

### 🔹 L - Liskov Substitution (Substituição de Liskov)

> Se funciona com a classe pai, tem que funcionar com a filha.

**No projeto:**
- Posso usar `ContratoAluguel` em qualquer lugar que aceite `Contrato`
- Tudo continua funcionando perfeitamente! 👌

---

### 🔹 I - Interface Segregation (Segregação de Interface)

> Interfaces pequenas e específicas > uma interface gigante.

**No projeto:**
- `IContrato` define só o essencial
- Ninguém é forçado a implementar métodos desnecessários! 🎯

---

### 🔹 D - Dependency Inversion (Inversão de Dependência)

> Dependa de abstrações, não de implementações.

**No projeto:**
- Trabalho com `IContrato`, não com `ContratoAluguel` específico
- Posso trocar implementações fácil! 🔄

---

### 📊 Resumão

| Princípio | O que é? | Benefício |
|-----------|----------|-----------|
| **S** | Uma responsabilidade por classe | 🎯 Fácil de manter |
| **O** | Estende sem modificar | 🔒 Código estável |
| **L** | Subclasses substituem superclasses | 🔄 Polimorfismo seguro |
| **I** | Interfaces enxutas | 📦 Menos dependências |
| **D** | Abstrações > implementações | 🔌 Código flexível |

---

## ⚙️ Requisitos

- ☕ **Java 21** (ou superior)
- 📦 **Maven 3.x**

---

## 🚀 Como Rodar

```bash
# Compilar
mvn clean package

# Rodar
java -cp target/classes com.ada.Main
```

Pronto! 🎉

---

## 📄 Licença

MIT License - fique à vontade para usar e aprender! 💙

---

## 👩‍💻 Sobre

Feito com ☕ e 💜 no programa **Elas+ Tech da Ada**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Joanna_Braccini-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joannabraccini/)

⭐ Curtiu? Dá uma estrela aí!

