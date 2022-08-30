
# Desafio Votação

Desafio técnico para avaliação dos conhecimentos. O mesmo foi criado uma API de Votação.

## Screenshots

![App Screenshot](https://github.com/wylliamnovais/desafio-votacao/blob/dd6e9bcb51755de915ccd36830a0c4c9ad2a8cf3/src/main/resources/estrutura/endpoints.png)




## Instalação



```bash
SDK --> Java 11
Banco --> Postgres
IDE --> Intellij
```
    
## Documentação da API

## API Votação.

## Version: 1.0.0

### /pauta/{id_pauta}

#### GET
##### Summary:

Endpoint Responsável por Consultar o resultado da Votação.

##### Description:

Método para consulta os votos da pauta.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id_pauta | path | Id da pauta. | Yes | long |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Pauta Cadastrada |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |

#### PUT
##### Summary:

Endpoint Responsável por Abrir a Votação da Pauta.

##### Description:

Método para abrir a votação da pautas.

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id_pauta | path | Id da pauta. | Yes | long |
| tempo_limite | query | Tempo Limite de Votação Aberta (Tempo em Minutos). | Yes | integer |

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Votação Iniciada com Sucesso |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |

### /votacao

#### POST
##### Summary:

Endpoint Responsável por votar na Pauta.

##### Description:

Método para enviar a votação do associado a pauta.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Voto computado com Sucesso. |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |

### /pauta

#### GET
##### Summary:

Endpoint Responsável por Listar as Pautas.

##### Description:

Método para listas as pautas.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Pauta Cadastrada |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |

#### POST
##### Summary:

Endpoint Responsável por criar a Pauta.

##### Description:

Método para criar a pauta.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Pauta Cadastrada |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |

### /associado

#### POST
##### Summary:

Endpoint Responsável por Cadastrar o Associado.

##### Description:

Método para cadastar o associado.

##### Responses

| Code | Description |
| ---- | ----------- |
| 200 | Id do Associado Cadastrado |
| 400 | Erro da Aplicação |
| 500 | Erro do Servidor |



## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)
[![whatsapp](https://img.shields.io/badge/whatsapp-0A66C2?style=for-the-badge&logo=whatsapp&logoColor=white)](https://wa.me/5561983133874)
