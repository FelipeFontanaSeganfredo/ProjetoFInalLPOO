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


Segue a documentação detalhada da modelagem apresentada no diagrama:

---

### **Modelagem de Classes**

O sistema é projetado para gerenciar operações logísticas em uma transportadora, utilizando conceitos de orientação a objetos. A seguir está a descrição das principais classes:

#### **1. Pessoa**
Classe base para representar informações comuns entre diferentes tipos de usuários no sistema.

- **Atributos:**
  - `id: int` - Identificador único.
  - `nome: String` - Nome completo.
  - `dataNascimento: Date` - Data de nascimento.
  - `email: String` - Endereço de e-mail.
  - `telefone: String` - Número de telefone.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **2. Cliente (Herdado de Pessoa)**
Representa os clientes da transportadora.

- **Atributos:**
  - `cnpj: String` - Cadastro Nacional da Pessoa Jurídica.

---

#### **3. Administrador (Herdado de Pessoa)**
Usuário responsável por gerenciar os dados da transportadora.

- **Atributos:**
  - `cpf: String` - Cadastro de Pessoa Física.

- **Métodos:**
  - `cadastraPedido(): Pedido` - Método para criar novos pedidos.
  - `cadastraCliente(): Cliente` - Método para registrar novos clientes.
  - `cadastraMotorista(): Motorista` - Método para registrar novos motoristas.
  - `agendaViagem(): Viagem` - Método para programar uma nova viagem.

---

#### **4. Motorista (Herdado de Pessoa)**
Responsável por conduzir caminhões e realizar viagens.

- **Atributos:**
  - `salario: float` - Salário do motorista.
  - `cnh: String` - Carteira Nacional de Habilitação.
  - `caminhao: Caminhao` - Caminhão designado ao motorista.

- **Métodos:**
  - `realizarViagem(): void` - Método para iniciar uma viagem.

---

#### **5. Pedido**
Representa os pedidos realizados por clientes.

- **Atributos:**
  - `id: int` - Identificador único do pedido.
  - `viagem: list<Viagem>` - Lista de viagens relacionadas ao pedido.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **6. Viagem**
Representa uma viagem programada para transporte de carga.

- **Atributos:**
  - `id: int` - Identificador único da viagem.
  - `valor: double` - Valor total da viagem.
  - `destino: Destino` - Local para onde a carga será transportada.
  - `motorista: Motorista` - Motorista responsável pela viagem.
  - `cliente: Cliente` - Cliente que requisitou o transporte.
  - `carga: Carga` - Carga transportada.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **7. Destino**
Local onde a carga será entregue.

- **Atributos:**
  - `id: int` - Identificador único do destino.
  - `nome: String` - Nome do destino.
  - `distancia: double` - Distância em relação ao ponto de origem.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **8. Estoque**
Gerencia os itens disponíveis para transporte.

- **Atributos:**
  - `id: int` - Identificador único do estoque.
  - `volume: float` - Volume total de itens disponíveis.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **9. Caminhão**
Representa os veículos utilizados para transporte.

- **Atributos:**
  - `id: int` - Identificador único do caminhão.
  - `motorista: Motorista` - Motorista designado ao caminhão.
  - `carga: Carga` - Carga transportada.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

#### **10. Carga**
Representa as cargas transportadas.

- **Atributos:**
  - `id: int` - Identificador único da carga.
  - `peso: float` - Peso total da carga.
  - `volume: float` - Volume total da carga.

- **Métodos:**
  - `toString(): String` - Representação textual do objeto.

---

### **Relacionamentos**

1. **Pessoa e suas subclasses:**
   - `Cliente` e `Administrador` herdam atributos e métodos comuns de `Pessoa`.

2. **Administrador e as operações:**
   - O `Administrador` gerencia `Pedido`, `Cliente`, `Motorista` e `Viagem`.

3. **Pedido e Viagem:**
   - Um `Pedido` pode conter várias `Viagens` (relação 1:N).

4. **Viagem e outras classes:**
   - Cada `Viagem` tem um `Motorista`, um `Cliente`, um `Destino` e uma `Carga`.

5. **Caminhão e Motorista:**
   - Um `Caminhão` é dirigido por um único `Motorista` (relação 1:1).

6. **Estoque e Carga:**
   - O `Estoque` pode conter várias `Cargas` (relação 1:N).

---

**Nesta versão do projeto nem todas as classes estão implementadas por completo.**


