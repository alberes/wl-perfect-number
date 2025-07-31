# Projeto: Verifica se o número inteiro positivo é um número perfeito
Este projeto é responsável por verificar se um número positivo é perfeito.
Para mais informações acesse o link [Perfect Number](https://en.wikipedia.org/wiki/Perfect_number)

### Tecnologias Utilizadas
* Frameworks: [Spring Boot 3.5.4](https://start.spring.io/)
* JDK: 21
* IDE: [Intellij](https://www.jetbrains.com/idea/)
* Gerenciado de dependencias: [Apache Maven 3.9.9](https://maven.apache.org/)
* Ferramentas: [Postman](https://www.postman.com/)
### Como Executar
1. Clone o repositório: git clone [wl-perfect-number](https://github.com/alberes/wl-perfect-number)
```
git clone https://github.com/alberes/wl-perfect-number.git
```

2. Executar o projeto
- Abrir o terminal na raiz do projeto [SUB_DIRETORIOS]/wl-perfect-number e exeuctar o comando abaixo para gerar o pacote.
```
mvn -DskipTests=true clean package
```

No termial entrar no diretório [SUB_DIRETORIOS]/wl-perfect-number/target
```
java -jar wl-perfect-number-0.0.1-SNAPSHOT.jar
```

A aplicação subirá na porta 8080

### Testes
1. Usar o comando cURL, navegador ou Postman
```
curl --location 'http://localhost:8080/api/v1/perfect-numbers' \
--header 'Content-Type: application/json' \
--data '{
    "start": 1,
    "end": 10000
}'
```
2. Swagger
```
http://localhost:8080/swagger-ui/index.html#/PerfectNumber/perfectNumbers
```
3. JUnit
- Executar via IDE ou Maven
  io.github.alberes.wlperfectnumber.services.PerfectNumberServiceTests