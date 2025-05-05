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

## 📁 Project Structure

cart-service/ ├── k8s/ # Kubernetes deployment files │ ├── cart/ # Cart service deployment/config │ ├── kafka/ # Kafka
setup (zookeeper, broker, etc.)
│ ├── mysql/ # MySQL deployment/config │ └── observability/ # Grafana, Loki, Promtail, etc. │ ├── src/ │ ├── main/ │ │
├── java/com/kims_convenience/cart_service/ │ │ │ ├── controllers/ # REST API endpoints (e.g., OrderController)
│ │ │ ├── dto/ # DTOs for data transfer │ │ │ │ ├── cart/ │ │ │ │ ├── checkout/ │ │ │ │ ├── oms/ │ │ │ │ └── requests/ │
│ │ ├── entities/ # JPA entity classes │ │ │ ├── exceptions/ # Custom exceptions and handlers │ │ │ ├── mappers/ #
Mapping logic (e.g., OrderMapper)
│ │ │ ├── messaging/ # Kafka producer config and event publishers │ │ │ ├── repositories/ # Spring Data JPA repositories
│ │ │ ├── services/ # Business logic layer │ │ │ ├── utility/ # Utility/helper classes │ │ │ └──
CartServiceApplication.java # Main Spring Boot application │ │ └── resources/ │ │ ├── application.yml # Spring Boot
config │ │ └── ... # Other resource files │ └── test/ # Test classes │ ├── Dockerfile # Docker image build configuration
├── .gitignore # Git ignored files ├── .gitattributes # Git attributes (e.g., for diff)
├── HELP.md # Spring initializer help ├── target/ # Build output (excluded from version control)
└── README.md # Project documentation

## 🛠️ Setup Instructions

### Clone the repository

git clone https://github.com/yourusername/yourproject.git

### Deploy MySQL

$ kubectl apply -f mysql-secret.yml

$ kubectl apply -f mysql-configmap.yml

$ kubectl apply -f mysql-deployment.yml

$ kubectl exec -it <container_id_or_name> -- /bin/bash

[# mysql -h mysql-cart -u root -p

[Enter password : password

[mysql> use cart-db;

[mysql> select * from orders;

$ kubectl get all

$ kubectl delete deployment mysql-deployment

$ kubectl delete service mysql-cart

$ kubectl delete pvc mysql-pvc

### Deploy Kafka

$ kubectl apply -f kafka-kraft-deployment.yaml

$ kubectl exec -it <pod_name> -- /bin/bash

[# cd /opt/kafka/bin

[# ./kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--topic order.placed \
--from-beginning

### Deploy Loki-Grafana

$ docker compose -f docker-compose-logging-observability.yml up -d

### Deploying Cart

$ mvn clean install

$ docker build -f Dockerfile -t anshikam/kims-convenience-cart .

$ docker push anshikam/kims-convenience-cart

$ kubectl scale --replicas=0 deployment cart-deployment

$ kubectl apply -f cart-configmap.yml

$ kubectl apply -f cart-deployment.yml

$ kubectl exec -it <pod_name> -- /bin/sh

$ kubectl logs <pod_name>
