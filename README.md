# ProjetoFinalLPOO
Repositório dedicado ao projeto final da disciplina de Linguagem de Programação Orientada a Objetos do IFSul Campus Passo Fundo, período 2024/2, é uma aplicação Java que visa auxiliar a logística interna de uma transportadora de areia, incluindo operações CRUD para suas classes principais, utilizando **JPA (Java Persistence API)** para a persistência dos dados em um banco de dados relacional e **Java Swing** para a construção de interfaces gráficas.

---

### **Funcionalidades**

A aplicação oferece as seguintes funcionalidades principais:

1. **Gerenciamento de Destinos:**
   - Cadastro, edição, listagem e exclusão de destinos, guardando a informação da distância até o depósito

2. **Gerenciamento de Clientes:**
   - Cadastro de clientes com informações básicas como nome e cnpj.
   - Consulta e atualização de dados dos clientes.

3. **Gerenciamento de Veículos:**
   - Cadastro e manutenção de registros de veículos utilizados nas operações.

4. **Gerenciamento de Motoristas:**
   - Cadastro de motoristas, incluindo dados pessoais e habilitações.
   - Vinculação de motoristas a transportes.
     
5. **Distribuição de responsabilidades:**
   - Há um sistema de login e áreas separadas para motoristas e administradores.

7. **Interface Gráfica:**
   - Interface amigável e intuitiva desenvolvida com Java Swing para fácil uso pelos colaboradores.

---

### **Tecnologias Utilizadas**

- **Java 17:** Versão principal utilizada no desenvolvimento.
- **Swing:** Para desenvolvimento de interfaces gráficas.
- **Jakarta Persistence API (JPA):** Para abstração da persistência.
- **Hibernate:** Implementação do JPA escolhida pelo projeto.
- **PostgreSQL:** Banco de dados relacional para armazenamento de dados.
- **Maven:** Para gerenciamento de dependências e automação de build.
- **NetBeans:** IDE recomendada para desenvolvimento.
- **JasperReports:** Para geração de relatórios.

---

### **Requisitos**

#### **Software Necessário**
- Java Development Kit (JDK) 21 ou superior.
- PostgreSQL 13 ou superior.
- Maven 3.8 ou superior.
- NetBeans 12 ou superior.

#### **Configuração de Banco de Dados**
1. Instale o PostgreSQL e configure uma nova base de dados com as seguintes informações:
   - **Nome do Banco:** `projeto_Final_Lpoo`
   - **Usuário:** `postgres`
   - **Senha:** `postgres`

---

### **Configuração do Projeto**

1. Clone este repositório:
   ```bash
   git clone https://github.com/FelipeFontanaSeganfredo/ProjetoFInalLPOO.git
   ```
2. Abra o projeto no **NetBeans**.
3. Configure as credenciais do banco de dados no arquivo `persistence.xml` localizado em `src/main/resources/META-INF`.
4. Compile e execute o projeto pelo NetBeans ou utilizando o Maven:
   ```bash
   mvn clean install
   mvn exec:java
   ```

---

### **Diagrama de Classes**

O diagrama de classes segue os princípios de orientação a objetos e está estruturado da seguinte forma:

![diagrama](https://github.com/user-attachments/assets/1911cbb0-e5d2-4902-99d3-47dba467be00)

**Nesta versão do projeto nem todas as classes estão implementadas por completo.**


