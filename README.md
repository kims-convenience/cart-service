# Project Name

A production-ready checkout system designed for scalability, observability, and clean architecture. Built with Spring
Boot and MySQL, deployed on Docker with monitoring through Grafana and Loki.

## 🚀 Features

-- Create and manage shopping carts

- Add/remove/update line items
- REST APIs with JSON payloads
- MySQL-backed persistent storage
- Deployed via Docker Compose & Kubernetes
- Centralized logging with Grafana + Loki

## 🧠 Architecture

- Java 17
- Spring Boot (MVC + JPA)
- MySQL
- Docker / Docker Compose
- Kubernetes (Docker Desktop)
- Grafana + Loki (for observability)
- GitHub Actions (for CI/CD – optional)

## 🛠️ Setup Instructions

### Clone the repository

git clone git@github.com:kims-convenience/cart-service.git

### Deploy MySQL

$ kubectl apply -f mysql-secret.yml

$ kubectl apply -f mysql-configmap.yml

$ kubectl apply -f mysql-deployment.yml

#### -- Accessing MySQL DB

$ kubectl exec -it <container_id_or_name> -- /bin/bash

[# mysql -h mysql-cart -u root -p

[Enter password : password

[mysql> use cart-db;

[mysql> select * from orders;

#### -- Other K8 resources for MySQL

$ kubectl get all

$ kubectl delete deployment mysql-deployment

$ kubectl delete service mysql-cart

$ kubectl delete pvc mysql-pvc

### Deploy Kafka

$ kubectl apply -f kafka-kraft-deployment.yaml

#### -- Accessing Kafka topics

$ kubectl exec -it <pod_name> -- /bin/bash

[# cd /opt/kafka/bin

[# ./kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic order.submitted \
--from-beginning

### Deploy Loki-Grafana

$ docker compose -f docker-compose-logging-observability.yml up -d

### Deploying Cart

#### -- Create & Push Docker Image

$ mvn clean install

$ docker build -f Dockerfile -t anshikam/kims-convenience-cart .

$ docker push anshikam/kims-convenience-cart

#### -- Deploy K8 resources for Cart

$ kubectl apply -f cart-configmap.yml

$ kubectl apply -f cart-deployment.yml

$ kubectl scale --replicas=0 deployment cart-deployment

#### -- Accessing pod

$ kubectl exec -it <pod_name> -- /bin/sh

$ kubectl logs <pod_name>
