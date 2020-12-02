
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

## API Details
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
      



## This App Works on Kubernetes
   <img src="https://github.com/aninditadatta12/stack-app/blob/main/images/kubernates.jpg" alt="drawing" width="1000" height="300"/>


## How to deploy this app on Kubernetes (MiniKube for Local)

   1. Deploy both data services 1st in our case Mongo and Postgres.
      All configuration files are there in /resources directory
   2. Commands used 
      #### For Mongo:
      
      * kubectl apply -f /Users/Documents/stack/src/main/resources/mongo.yaml --validate=false
      
      #### For Postgres:
      
      * kubectl create -f /Users/Documents/stack/src/main/resources/postgres-configmap.yaml
      * kubectl create -f /Users/Documents/stack/src/main/resources/postgres-storage.yaml
      * kubectl create -f /Users/Documents/stack/src/main/resources/postgres-deployment.yaml
      * kubectl create -f /Users/Documents/stack/src/main/resources/postgres-service.yaml
      
   3. Now lets build our spring-boot app and push to docker hub
      Build it image using commnd: 
      * docker build -t aninditadatta12/stackapp .
      
      Please ensure you are in parent directory
      
      Then push the image to docker hub:
      
      * docker push aninditadatta12/stackapp:latest
      
   4. Now let's deploy our app:
   
      kubectl create deployment stackapp --image=aninditadatta12/stackapp:latest
      
  5. As we are not exposing our app on external port then we can expose it to access using command.
  
      * kubectl port-forward service/stackapp 7080:8080

 6. Now we will be able to access the app on port localhost:7080
