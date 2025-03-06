
# Transação API

Este projeto é uma API REST para gerenciar transações e calcular estatísticas das transações realizadas nos últimos 60 segundos. A API foi desenvolvida com Java e Spring Boot.


## Variáveis de Ambiente
Para rodar esta aplicação, você precisa de:

Java: JDK 17 ou superior. Maven: Versão 3.8.1 ou superior. Git: Para clonar o repositório. Docker (opcional): Caso queira rodar a aplicação em um container.
## Como Configurar o Projeto

1 . Clone o Repositório

2 . Compile o Projeto

 mvn clean install




```http
  mvn clean install
```

3 . Execute o Projeto

```http
  mvn spring-boot:run
```
4 . Como Rodar em um Container (Opcional)

4.1. Crie a Imagem Docker Certifique-se de que o Docker está instalado e execute:
```http
docker build -t api-transacoes .
```
4.2. Execute o Container
```http
docker run -p 8080:8080 api-transacoes
```


## Documentação da API
Receber Transações

## Endpoints da API

### Criar Transação
```http
POST /transacao
```
| Parâmetro   | Tipo           | Descrição                                        |
|------------|--------------|------------------------------------------------|
| `valor`    | `BigDecimal`  | **Obrigatório.** O valor da transação          |
| `dataHora` | `OffsetDateTime` | **Obrigatório.** O horário que a transação ocorreu |

---

### Limpar Transações
```http
DELETE /transacao
```
---

### Calcular Estatísticas
```http
GET /estatistica
```
| Parâmetro        | Tipo     | Descrição                                      |
|-----------------|---------|----------------------------------------------|
| `intervaloSegundos` | `integer` | **Não Obrigatório.** O padrão default é 60s |
