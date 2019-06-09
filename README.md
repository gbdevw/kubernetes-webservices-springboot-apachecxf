## Simple web service on Kubernetes (Spring Boot + Apache CXF + Docker)

This project shows how to run a simple containerized Spring Boot & Apache CXF web service on Kubernetes.

### Run locally

Use Maven :

```bash
mvn clean
mvn package
mvn exec:java
```

Use the public docker image :

```bash
docker run -p 8080:8080 guillaumebraibant/k8s-ws-sboot-cxf:1.0.0
```

You can either build and run the jar or build and run the container.

### Deploy on Kubernetes (Minikube)

It is assumed that your Minikube VM is properly configured and has ingress enabled. It is also assumed that you can issue command through kubectl and that you can create namespace, deployment, service and pod resources.

Use the multiple resources .yaml file :

```bash
kubectl apply -f ./webservice-deployment.yaml
```

This file creates :

- A namespace "k8s-ws-sboot-cxf-gb" where all resources will be located
- A service resource to manage pods
- A deployment resource that defines 4 pods that use the public docker image
- An ingress resource thatexpose the web service to the outside of Kubernetes

Once you are done, delete all resources :

```bash
kubectl delete namespace k8s-ws-sboot-cxf-gb
```

### Endpoints

There are 3 main endpoints :

- http://localhost:8080/services :
It is the main page of the UDDI that exposes the web service medata
- http://localhost:8080/services/sayhello :
It is the endpoint used by the web service to receive requests
- http://localhost:8080/services/sayhello?wsdl :
This URL points the .wsdl file that describes the web service

Note : If you run the application on Minikube, you the port 80 (default http) and replace the localhost by the IP address displayed by :

```bash
minikube ip
```

### Test

Use the integration test :

```bash
mvn test
```

Or create a client or use a tool like SoapUI
