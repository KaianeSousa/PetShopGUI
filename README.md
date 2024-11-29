
# Sistema de Pet Shop
Este projeto é um sistema de gerenciamento para pet shops, desenvolvido em Java com uma interface gráfica utilizando a biblioteca Swing. 
O sistema permite o cadastro de clientes, animais de estimação, escolha de serviços e marcação do mesmo , além de oferecer funcionalidades de autenticação e interação com um banco de dados MySQL.

## Funcionalidades
- **Cadastro de Clientes:** Permite que novos clientes se cadastrem no sistema ao fornecerem informações como nome, telefone, e-mail, endereço e senha.
- **Cadastro de Animais:** Clientes podem cadastrar seus animais de estimação (mas não se vinculam a eles no momento).
- **Agendamento de Serviços:** Possibilita o agendamento de serviços como banho e tosa.
- **Autenticação:** Permite que os administradores acessem o sistema através de um login validado.
- **Persistência de Dados:** Os dados são armazenados em um banco de dados MySQL, utilizando JDBC para gerenciamento de conexões e operações SQL.

  ## Tecnologias Utilizadas
- **Java:** Linguagem de programação principal utilizada para desenvolver o sistema.
- **Swing:** Biblioteca Java para a construção da interface gráfica do usuário (GUI).
- **PostgreSQL:** Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados.
- **JDBC:** Para a conexão entre o aplicativo Java e o banco de dados.

## Requisitos
- **Java Development Kit (JDK):** Ter o JDK instalado.
- **MySQL:** Ter um banco de dados MySQL e que ele fique em execução durante as operações no sistema.
- **Driver JDBC:** O driver JDBC para MySQL deve ser adicionado ao projeto.
