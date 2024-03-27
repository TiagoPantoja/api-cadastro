# Desafio: Cadastro de pessoas

---

## Decisões Técnicas

Utilizei Java EE para desenvolver uma aplicação web simples com funcionalidades CRUD para entidades Pessoa e Endereço. Abaixo estão as decisões técnicas:

1. **Java EE:**
    - Java EE utilizando Injeção de Dependência com EJB, Hibernate para implementar o JPA, JSF com Prime Faces, entre outros.

2. **Projeto MVC:**
    - Padrão MVC para separação de responsabilidades entre modelo, visão e controle.

3. **Injeção de Dependências:**
    - Uso de injeção de dependências para facilitar a configuração de componentes na aplicação.

4. **Persistência de Dados:**
    - Utilização do Hibernate para mapeamento de dados no banco de dados.

5. **Interface Web:**
    - Implementação de interfaces com JSF e utilização de Prime Fraces para criar páginas.

6. **Camada de Serviço:**
    - Separação das regras de negócio em camadas de serviço para manter a lógica da aplicação desacoplada das interfaces.

---

## Instruções

### Pré-requisitos:
- Java e JDK instalados na versão 8 ou superior, preferencialmente 17 ou 21;
- Apache Maven para gerenciamento de dependências e build do projeto;
- Servidor de Aplicação Java EE como Apache Tomcat para executar a aplicação web.

### Compilação:
1. Clone o repositório do projeto em sua máquina local.
2. Abra o terminal e navegue até a pasta raiz do projeto.
3. Execute o comando `mvn clean install` para compilar o projeto e gerar o arquivo WAR.

### Execução:
1. Após compilar, copie o arquivo WAR para a pasta `webapps` do servidor de aplicação Java, como Apache Tomcat.
2. Inicie o servidor de aplicação executando o script de inicialização, como `startup.sh` ou `startup.bat`.
3. Acesse a aplicação no navegador no endereço `http://localhost:8080/nome-da-aplicacao`, substituindo `nome-da-aplicacao` pela sua aplicação no servidor.

---

## Execução dos Testes Unitários

### Testes Unitários:
1. Para executar os testes unitários, abra o terminal na pasta raiz do projeto.
2. Execute o comando `mvn test` para rodar todos os testes unitários do projeto.

---

## Observação

- Certifique-se de configurar corretamente o arquivo `persistence.xml` com as informações de conexão com o banco de dados.

---

### Configuração do Banco de Dados

#### Configuração do `persistence.xml`:
1. Abra o arquivo `persistence.xml` no diretório `src/main/resources/META-INF` do projeto.
2. Configure as propriedades de conexão com o banco de dados, como URL, usuário e senha.

Exemplo de configuração do `persistence.xml`:

```xml
<persistence-unit name="nome-da-unidade">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <properties>
        <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
        <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/nome-do-banco"/>
        <property name="javax.persistence.jdbc.user" value="usuario-do-banco"/>
        <property name="javax.persistence.jdbc.password" value="senha-do-banco"/>
       
        <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
    </properties>
</persistence-unit>
```
3. Certifique-se de substituir `nome-da-unidade`, `nome-do-banco`, `usuario-do-banco` e `senha-do-banco` pelas informações corretas.

---
## Criação das Tabelas

### Scripts SQL:

1. Abra o seu cliente PostgreSQL.
2. Execute os scripts SQL para criar as tabelas das entidades Pessoa e Endereço.

Script SQL para criar a tabela Pessoa:

```
CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT,
    sexo CHAR(1)
);
```

Script SQL para criar a tabela Endereço:

```
CREATE TABLE endereco (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
estado VARCHAR(255),
cidade VARCHAR(255),
logradouro VARCHAR(255),
numero INT,
cep VARCHAR(10),
id_pessoa BIGINT,
FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);
```