#Trabalho_Crud_Dev_WEB

O projeto implementa um conjunto básico de operações CRUD para gerenciamento de registros em um servidor Java. As operações CRUD são:

Create (Criar)
Descrição: Adiciona um novo registro ao sistema.
Método HTTP: POST
Endpoint: /api/registro
Corpo da Requisição: Dados do novo registro no formato JSON.


Read (Ler)
Descrição: Recupera e exibe um registro existente com base no seu identificador.
Método HTTP: GET
Endpoint: /api/registro/{id}
Parâmetros: id - Identificador do registro.


Update (Atualizar)
Descrição: Modifica os dados de um registro existente.
Método HTTP: PUT
Endpoint: /api/registro/{id}
Corpo da Requisição: Dados atualizados do registro no formato JSON.


Delete (Excluir)
Descrição: Remove um registro existente do sistema.
Método HTTP: DELETE
Endpoint: /api/registro/{id}
Parâmetros: id - Identificador do registro. Cada operação é acessada por meio de um endpoint HTTP específico, permitindo a manipulação dos registros no sistema de maneira simples e eficiente.
