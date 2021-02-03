# backend-challenge

## O que é o projeto?
O Projeto consiste em disponibilizar uma api rest para validação de senha, a qual deve seguir algumas regras conforme descrita abaixo

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto.
- Espaços em branco não devem ser considerados como caracteres válidos.

## Tecnologias:
- Kotlin
- Spring boot
- Spring Actuator
- Swagger
- Docker
- Docker-compose

## Como rodar:
No diretório do projeto há um arquivo docker-compose.yml com os serviços de banco e da aplicação, ele utiliza o DockerFile o qual já se encontra com o processo de build e subida da aplicação.

**Comando para subida:** docker-compose up -d

## Motivações e decisões

Dados os requisitos do desafio decidi por implementar as regras de validações individuais, ou seja, para cada validação há uma função, isso garante com que caso seja necessário alterar/incluir/excluir uma regra podemos fazer isso na classe de serviço, que apenas agrupa as regras solicitadas.

O exemplo de sucesso dar-se pelo json abaixo:

~~~
{
    "password":"AbTp9gf@ok!"
}
~~~

Este teste tem como retorno um boolean conforme requisito. 

~~~
true
~~~

Decidi também implementar um mecanismo de erros, o qual dado uma validação há um código de erro especifico para cada um dos casos. por exemplo:

Dado que a api foi chamada com o json abaixo:

~~~ 
  {
      "password":"AbTp9gf@ok!!"
  }
~~~

este password cai no caso de caracteres repetidos, pelo cenário é retornado o erro 400 com o seguinte body.
~~~
  {
    "error_code": "ERROR-07",
    "error_message": "your password cannot contain repeated characters"
  }
~~~
Os códigos e descrições dos erros encontra-se no arquivo **errors.properties**,  


## Rotas disponíveis:
- Post - http://localhost:8080/v1/password - Url de validação de senha. 

    Exemplo de body para chamada:
  ~~~
    {
      "password":"AbTp9gf@ok!"
    }
  ~~~
- Get - http://localhost:8080/swagger-ui.html - Url com a documentação da api
- Get - http://localhost:8080/actuator/health - Url para verificar o status da aplicação