# CRUD Java

O projeto implementa um conjunto básico de operações CRUD para gerenciamento de registros em um servidor Java. As operações CRUD são:

### Create (Criar) <br>
Descrição: Adiciona um novo registro ao sistema. <br>
Método HTTP: POST <br>
Endpoint: /api/registro <br>
Corpo da Requisição: Dados do novo registro no formato JSON. <br><br>
### Read (Ler) <br>
Descrição: Recupera e exibe um registro existente com base no seu identificador. <br>
Método HTTP: GET <br>
Endpoint: /api/registro/{id} <br>
Parâmetros: id - Identificador do registro. <br><br>
### Update (Atualizar) <br>
Descrição: Modifica os dados de um registro existente. <br>
Método HTTP: PUT <br>
Endpoint: /api/registro/{id} <br>
Corpo da Requisição: Dados atualizados do registro no formato JSON. <br><br>
### Delete (Excluir) <br>
Descrição: Remove um registro existente do sistema. <br>
Método HTTP: DELETE <br>
Endpoint: /api/registro/{id} <br>
Parâmetros: id - Identificador do registro.
Cada operação é acessada por meio de um endpoint HTTP específico, permitindo a manipulação dos registros no sistema de maneira simples e eficiente.


