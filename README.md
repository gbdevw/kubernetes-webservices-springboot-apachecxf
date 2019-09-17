## Simple web service on Kubernetes (Spring Boot + Apache CXF + Docker)

This project shows how to run a simple containerized Spring Boot & Apache CXF web service on Kubernetes.

### Features

- Simple webservice application with Spring Boot and Apache CXF
- wsdl2java Maven plugin setup to work in a WSDL-first fashion
- Simple containerization of the application
- Simple deployment on Kubernetes using standard features

### Prerequisites

- Maven
- Docker
- Minikube

### Generate sources from wsdl and xsd files

Run the following command to (re)generate webservices java classes

```bash
mvn clean generate-sources
```

### Build

Build with test phase :

```bash
mvn package
```

Build without test phase :

```bash
mvn package -DskipTests
```

### Run locally

Use the public docker image :

```bash
docker run -p 8080:8080 guillaumebraibant/k8s-ws-sboot-cxf:1.0.0
```

You can either build and run the jar (using Maven) or build and run the container.

### Deploy on Kubernetes (Minikube)

It is assumed that your Minikube VM is properly configured. It is also assumed that you can issue command through kubectl and that you can create namespace, deployment, service (NodePort and Headless) and pod resources.

Use the multiple resources .yaml file :

```bash
kubectl apply -f ./webservice-deployment.yaml
```

This file creates :

- A namespace "k8s-ws-sboot-cxf-gb" where all resources will be located
- A headless service to manage pods
- A deployment resource that defines 4 pods that use the public docker image
- A NodePort (port 31001) service to allow access from outside the K8S cluster to the webservice application pods

Once you are done, delete all resources :

```bash
kubectl delete namespace k8s-ws-sboot-cxf-gb
```

Note : You can use an Ingress resource instead of a Nodeport service as the SOAP protocol operates over HTTP.

### Endpoints - Local (local docker host or local run)

There are 3 main endpoints :

- http://localhost:8080/services :
It is the main page of the UDDI that exposes the web service medata
- http://localhost:8080/services/sayhello :
It is the endpoint used by the web service to receive requests
- http://localhost:8080/services/sayhello?wsdl :
This URL points the .wsdl file that describes the web service

### Endpoints - Minikube

If you run the application on Minikube, use the port 31001 and replace the localhost by the IP address displayed by :

```bash
minikube ip
```

- http://<minikube-ip>:31001/services :
It is the main page of the UDDI that exposes the web service medata
- http://<minikube-ip>:31001/services/sayhello :
It is the endpoint used by the web service to receive requests
- http://<minikube-ip>:31001/services/sayhello?wsdl :
This URL points the .wsdl file that describes the web service

### Test

Use the unit and integration test :

```bash
mvn test
```

Or create a client or use a tool like SoapUI.
