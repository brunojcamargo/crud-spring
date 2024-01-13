
# CRUD com Spring Boot

CRUD de produtos e categorias com Spring Boot.


## Dependência

[Docker](https://www.docker.com/products/docker-desktop/)


## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/brunojcamargo/crud-spring
```

Entre no diretório do projeto

```bash
  cd crud-spring
```

Inicie o servidor

```bash
  docker compose up
```


## Documentação API
### Category

- **getAll**
    - **Descrição:** Obter todas as categorias.
    - **Método:** GET
    - **URL:** `{{url}}/api/category`

- **Add**
    - **Descrição:** Adicionar uma nova categoria.
    - **Método:** POST
    - **URL:** `{{url}}/api/category`
    - **Corpo:**
      ```json
      {
          "title": "Categoria Teste",
          "description": "Categoria de teste",
          "ownerId": "1abcdEf"
      }
      ```

- **Update**
    - **Descrição:** Atualizar uma categoria existente.
    - **Método:** PUT
    - **URL:** `{{url}}/api/category/{{categoryId}}`
    - **Corpo:**
      ```json
      {
          "title": "Categoria Teste",
          "description": "Categoria de teste2",
          "ownerId": "1abcdEf"
      }
      ```

- **Delete**
    - **Descrição:** Excluir uma categoria existente.
    - **Método:** DELETE
    - **URL:** `{{url}}/api/category/{{categoryId}}`

### Product

- **getAll**
    - **Descrição:** Obter todos os produtos.
    - **Método:** GET
    - **URL:** `{{url}}/api/product`

- **Add**
    - **Descrição:** Adicionar um novo produto.
    - **Método:** POST
    - **URL:** `{{url}}/api/product`
    - **Corpo:**
      ```json
      {
          "title": "Produto Teste 3",
          "description": "Produto de teste",
          "ownerId": "1abcdEf",
          "price": 1090,
          "categoryId": "{{categoryId}}"
      }
      ```

- **Update**
    - **Descrição:** Atualizar um produto existente.
    - **Método:** PUT
    - **URL:** `{{url}}/api/product/{{productId}}`
    - **Corpo:**
      ```json
      {
          "title": "Produto Teste",
          "description": "Produto de teste",
          "ownerId": "1abcdEf",
          "price": 1090,
          "categoryId": "{{categoryId}}"
      }
      ```

- **Delete**
    - **Descrição:** Excluir um produto existente.
    - **Método:** DELETE
    - **URL:** `{{url}}/api/product/{{productId}}`