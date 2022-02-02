# University Registry

Simple Spring Boot Web API app. Features:
- GET, POST, PUT, DELETE requests.
- PostgreSQL database.

## Deploy

Can be deployed in Docker and/or in Kubernetes. To do this have *Java*, *Docker*, *Minikube* installed.

Run following commands:
1. `minikube start --driver=docker` to start Kubernetes. If you need to clear current setup, run `minikube delete` before it.
2. `./mvnw -DskipTests package` to build Spring Boot app.
3. `docker build -t besedinalexey/university-registry:v1 .` to create Docker image.
4. `docker push besedinalexey/university-registry:v1` to push it in to Docker Hub. Kubernetes' configs use images from there.
5. `kubectl apply -f k8s/db.yaml` to deploy PostgreSQL.
6. `kubectl apply -f k8s/app.yaml` to deploy Spring Boot app.
7. `minikube service university-registry --url` to get IP and Port to connect to it.

- To test Web API use [Postman](https://www.postman.com/).
- If something goes wrong, check status with `kubectl get all -o wide`.