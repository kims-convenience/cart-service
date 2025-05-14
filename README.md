# Project Name

A production-ready cart-checkout system designed for scalability, observability, and clean architecture. Built with
Spring Boot and MySQL, deployed on Docker with monitoring through Grafana and Loki.

## 🚀 Features

-- Create and manage shopping carts

- Add/remove/update line items
- REST APIs with JSON payloads
- MySQL-backed persistent storage
- Kafka messaging to decouple Order service
- Deployed via Docker & Kubernetes
- Centralized logging with Grafana + Loki

## 🧠 Architecture

- Java 17
- Spring Boot (MVC + JPA)
- MySQL
- Kafka
- Docker / Docker Compose
- Kubernetes (Docker Desktop)
- Grafana + Loki (for observability)
- GitHub Actions (for CI/CD – optional)

## 🛠️ Setup Instructions

### Clone the repository

git clone git@github.com:kims-convenience/cart-service.git

### Deploy Loki-Grafana

$ docker compose -f docker-compose-observability.yml up -d

Access Grafana - http://localhost:3000/

### Deploy Kafka

$ kubectl apply -f kafka-kraft-deployment.yml

#### -- Accessing Kafka messages

$ kubectl exec -it <pod_name> -- /bin/bash

[# cd /opt/kafka/bin

[# ./kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic order.submitted \
--from-beginning

#### -- Accessing Kafka messages with metadata

$ kubectl exec -it <pod_name> -- /bin/bash

[# cd /opt/kafka/bin

[# ./kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic order.submitted \
--from-beginning \
--property print.key=true \
--property print.headers=true \
--property print.timestamp=true \
--property print.partition=true \
--property print.offset=true

### Deploy MySQL

$ kubectl apply -f mysql-secret.yml

$ kubectl apply -f mysql-configmap.yml

$ kubectl apply -f mysql-deployment.yml

#### -- Accessing MySQL DB

$ kubectl exec -it <container_id_or_name> -- /bin/bash

[# mysql -h kc-cart-mysql-service -u root -p

[Enter password : password

[mysql> use cart_db;

[mysql> select * from orders;

#### -- Other K8 resources for MySQL

$ kubectl get all

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
