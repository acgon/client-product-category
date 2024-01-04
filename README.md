# CRUD básica utilizando Spring Boot
Este projeto visa implementar uma CRUD básica utilizando Spring Boot seguindo um modelo simples, criado apenas para satisfazer exigências de quantidade de tabelas e relacionamentos. Desta forma, não necessariamente esta modelagem faria sentido no mundo real, em um ambiente de produção. Como este é um primeiro projeto e está sendo utilizado para aprendizagem, estará sujeito a alterações e atualizações de tempos em tempos.

## Tabelas:

Cliente: Armazena informações sobre os clientes.
Pedido: Registra detalhes dos pedidos feitos pelos clientes.
Produto: Contém informações sobre os produtos disponíveis.
Categoria: Representa as categorias às quais os produtos pertencem.

## Relacionamentos:

###Relacionamento 1 para 1 (1:1):
Entre Cliente e Pedido.
Cada cliente pode fazer apenas um pedido (e vice-versa).
Exemplo: Um cliente faz um único pedido.

### Relacionamento 1 para muitos (1:N):
Entre Produto e Pedido.
Um pedido pode conter vários produtos, mas cada produto pertence a apenas um pedido.
Exemplo: Um pedido inclui vários produtos.

### Relacionamento muitos para muitos (N:N):
Entre Produto e Categoria.
Um produto pode pertencer a várias categorias, e uma categoria pode ter vários produtos.
Exemplo: Um produto pode ser classificado em várias categorias (por exemplo, “Eletrônicos” e “Acessórios”).
