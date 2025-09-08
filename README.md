
# Projeto: Verifica se o número inteiro positivo é um número perfeito
Este projeto é responsável por verificar se um número positivo é perfeito.  
Para mais informações acesse o link [Perfect Number](https://en.wikipedia.org/wiki/Perfect_number)

### Tecnologias Utilizadas
* Frameworks: [Spring Boot 3.5.4](https://start.spring.io/)
* JDK: 21
* IDE: [Intellij](https://www.jetbrains.com/idea/)
* Gerenciado de dependencias: [Apache Maven 3.9.9](https://maven.apache.org/)
* Ferramentas: [Postman](https://www.postman.com/)
* Container:
  * [Docker](https://www.docker.com/)
  * [Docker Hub](https://hub.docker.com/)
  * [minikube](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download)
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
 "start": 1, "end": 10000}'  
```  
2. Swagger
```  
http://localhost:8080/swagger-ui/index.html#/PerfectNumber/perfectNumbers  
```  
3. JUnit
- Executar via IDE ou Maven  
  io.github.alberes.wlperfectnumber.services.PerfectNumberServiceTests

### Docker

1. Montando um ambiente Docker
- Criando uma imagem da aplicação
```  
docker build --tag alberes/wl-perfect-number:1.0.0 .  
```  
- Subindo um container Docker da aplicação register-manager-resource-server
```  
docker run --name wl-perfect-number -p 8080:8080 -d alberes/wl-perfect-number:1.0.0  
```  
- Listar containers
```  
docker ps ou docker ps -a  
```  
- Para o container
```  
docker stop wl-perfect-number  
```  

### Kubernetes
- Iníciar o minikube
```  
minikube start  
```  
- Criar um Pod (Uma unidade que contém um ou mais containers)
```  
kubectl apply -f wl-perfect-number-pod.yaml  
```  
- Listar os pods
```  
kubectl get pods  
```  
- Expor o serviço para ser acessado na porta 8080
```  
kubectl port-forward pod/wl-perfect-number-pod 8080:8080  
```  
- Excluir um pod
```  
kubectl delete pod wl-perfect-number-pod  
```  
- Criando replicas (Um ou mais Pods)
```  
kubectl apply -f .\wl-perfect-number-replicaset.yaml  
```  
- Use o comando abaixo para listar os pods criados
```  
kubectl get pods  
```  
- Expor o serviço para ser acessado na porta 8080 (substituir [id]):
```  
kubectl port-forward pod/wl-perfect-number-replicaset-[id] 8080:8080  
```  
- Excluir um ReplicaSet
```  
kubectl delete rs wl-perfect-number-replicaset  
```  
- Criando um Deployment para criar um replicaset e pods de uma só vez e gerencia as versões do container.
```  
kubectl apply -f wl-perfect-number-deployment.yaml  
```  
- Lista o deployment
```  
kubectl get deployments  
```  
- Após criar o deployment precisa criar o service para o kubernetes fazer o balanceamento entre os Pods
```  
kubectl apply -f wl-perfect-number-service.yaml  
```  
- Lista os serviços
```  
kubectl get svc  
```  
- Expor o serviço para ser acessado na porta 8080
```  
kubectl port-forward svc/wl-perfect-number-service 8080:8080  
```  
ou
```  
minikube service wl-perfect-number-service --url  
```