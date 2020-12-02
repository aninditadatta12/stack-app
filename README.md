# stack-app
## Use Case: 
Implement stack (LIFO) using micro service architecture and deploy minikube environment using docker and Kubernetes tools

1. Core Language: Java
2. Framework: Spring Boot
3. Persistent storage: Postgre and Mongo
4. Design & Document Tool: Swagger
5. Container: Docker
6. Build Tool: Gradle
7. Deployment Platform: Kubernetes (Minikube)
8. Gradle workflow enable for CI in github

##### API Details
1. * Push Operation:

    * http://localhost:7080/push
    * Body:
      {
  "data": 104,
  "db": "postgres"
}
<img src="https://github.com/aninditadatta12/stack-app/blob/main/images/push_operation.jpg" alt="drawing" width="1000" height="300"/> 


2. * Pop Operation: 
    * http://localhost:7080/pop?db=postgres
    
    <img src="https://github.com/aninditadatta12/stack-app/blob/main/images/pop_operation.jpg" alt="drawing" width="1000" height="300"/>
    
    
3. * Get Operation:
    * http://localhost:7080/get?db=postgres
    
   <img src="https://github.com/aninditadatta12/stack-app/blob/main/images/get_operation.jpg" alt="drawing" width="1000" height="300"/>
