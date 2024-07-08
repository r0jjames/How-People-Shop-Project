# How People Shop (HPS) Product - Assignment

## Overview

The "How People Shop" (HPS) product aims to build a digital, web-based solution to collect, store, catalogue, and share insights into customer shopping experiences. This product will enable decision-makers within IKEA to understand consumer behavior, enhancing the IKEA customer experience and driving consumer-centric decision-making.

<!-- ## Vision

Develop a product that continuously collects data on people's shopping behaviors, interactions, and engagements with retailers and platforms offering home furnishing products and services. This product will enable innovation, expansion, and the development of IKEA's omnichannel experience. -->

## Goals

- Store and catalogue existing knowledge about customer shopping experiences.
- Make the data easily searchable and accessible from within the HPS web-based product.
- Drive consumer-centric decision-making by providing insights into customer needs and behaviors.
- Strengthen the IKEA concept and ensure business growth.

## Table of Contents

1. [Architecture Diagram](#architecture-diagram)
2. [Sequence Diagram](#sequence-diagram)
3. [Unified Data Model](#unified-data-model)
4. [Technologies and Tools Integration](#technologies-and-tools-integration)
    - [Core Microservices](#core-microservices)
    - [Data Processing and Storage](#data-processing-and-storage)
    - [Observability and Data Quality](#observability-and-data-quality)
    - [Security and Authentication](#security-and-authentication)
5. [Data Flow and Integration](#data-flow-and-integration)
6. [Data Processing](#data-processing)
    - [ETL Process](#etl-process)
    - [Handling Structured and Unstructured Data](#handling-structured-and-unstructured-data)
    - [Scalability](#scalability)
    - [Trigger Mechanisms](#trigger-mechanisms)

7. [How to Run the Project](#how-to-run-the-project)
8. [Glossary of Terms](#glossary-of-terms)

## Architecture Diagram

![Architecture Diagram](diagrams/Architecture_Diagram.png)

## Components Communication flow
![Components](diagrams/Components.png)
![Sequence Diagram](diagrams/Sequence_Diagram.png)

## Data Model

![Unified Data Model](diagrams/Data_Model.png)
#### Descriptions:

The HPS Data Model captures the various entities and their relationships involved in understanding customer shopping experiences. The key tables and their relationships are as follows:

| **Entity**                | **Description**                                                                                   |
|---------------------------|---------------------------------------------------------------------------------------------------|
| **Customers**             | Stores information about customers, including their name, email, and phone.                        |
| **Needs**                 | Captures different types of customer needs such as Replacement, Upgrade, or Remodel.               |
| **Product Clusters**      | Represents various product clusters like Quick Pickers, Storage Solvers, and Lasting Comfort.       |
| **Triggers**              | Includes different types of triggers that can influence shopping behavior.                         |
| **Missions**              | Defines the customer's mission types, like Solution Seeking or Recreational Shopping.              |
| **Touchpoints**           | Captures various touchpoints where customers interact with the brand.                              |
| **Journey Phases**        | Represents different phases of the customer journey.                                               |
| **Places of Purchase**    | Captures the place of purchase, either Store or Online.                                             |
| **Customer Experiences**  | Links customer interactions with various aspects of their shopping journey.                         |
| **Product Insights**      | Stores insights related to product clusters and their triggers.                                     |


## Technologies and Tools Integration

### Core Microservices

| **Aspect**                  | **Technologies**                                                                                 | **Specifications**                                                                                                                                      |
|-----------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Customer Experience Service** | Java, Spring Boot, Azure Kubernetes Service (AKS), Azure Container Registry, Azure Active Directory (AAD) | Manages customers profiles, preferences, and shopping behavior data.                                                                                                      |
| **Products Service**        | Java, Spring Boot, Azure Kubernetes Service (AKS), Azure Container Registry, Azure Active Directory (AAD) | Provide product-related data for analysis and recommendations.                                                                                                               |
| **Insights Service**        | Java, Spring Boot, Azure Kubernetes Service (AKS), Azure Container Registry, Azure Active Directory (AAD) | Analyzes collected data to provide insights into customer behavior, needs, and trends.                                                                                                        |

### Data Processing and Storage

| **Aspect**                  | **Technologies**                                                                                 | **Specifications**                                                                                                                                      |
|-----------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Data Ingestion**          | Azure Data Factory                                                                              | Pull data from various sources.                                                                                                                          |
| **Data Transformation**     | Azure Databricks                                                                                | Transform and process data within microservices.                                                                                                         |
| **Data Storage**            | Azure Synapse Analytics, Azure Data Lake Storage, Elastic Search, SQL Database (Azure SQL Database) | Store structured and unstructured data, and index for efficient retrieval.                                                                                |

### Observability and Data Quality

| **Aspect**                  | **Technologies**                                                                                 | **Specifications**                                                                                                                                      |
|-----------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Monitoring**              | Prometheus, Grafana                                                                             | Real-time monitoring and visualization.                                                                                                                  |
| **Observability**           | Azure Monitor                                                                                   | Comprehensive monitoring and diagnostics.                                                                                                                |
| **Data Quality**            | Azure Data Catalog                                                                              | Maintain data quality and governance.                                                                                                                    |

### Security and Authentication

| **Aspect**                  | **Technologies**                                                                                 | **Specifications**                                                                                                                                      |
|-----------------------------|--------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Authentication**          | Azure Active Directory (AAD)                                                                    | Authenticate users and applications.                                                                                                                     |
| **Authorization**           | Azure Active Directory (AAD)                                                                    | Implement role-based access control (RBAC).                                                                                                              |
| **Secret Management**       | Azure Key Vault                                                                                 | Store and manage secrets securely.                                                                                                                       |

## Data Flow and Integration

| **Step**                   | **Description**                                                                                   |
|----------------------------|---------------------------------------------------------------------------------------------------|
| **Data Ingestion**         | Use Azure Data Factory to pull data from various sources (databases, APIs, files). Stream real-time data through Apache Kafka to appropriate microservices. |
| **Data Transformation**    | Use Azure Databricks for transforming and processing data within microservices


## Data Processing

### ETL Process

| **Aspect**            | **Technologies**                                                                                       | **Specifications**                                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Data Extraction**   | Azure Data Factory                                                                                    | Connect to various data sources, including databases, APIs, and file systems.                                                                            |
| **Data Transformation** | Azure Databricks                                                                                     | Leverage for scalable data cleaning, normalization, and transformation.                                                                                   |
| **Data Loading**      | Azure Synapse Analytics                                                                               | Store transformed data for efficient querying and analysis.                                                                                              |

### Handling Structured and Unstructured Data

| **Aspect**            | **Technologies**                                                                                       | **Specifications**                                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Data Classification** | Azure Data Lake Storage                                                                              | Store both structured and unstructured data.                                                                                                             |
| **Processing Frameworks** | Azure Databricks                                                                                   | Process and analyze large volumes of unstructured data.                                                                                                  |
| **Indexing and Search** | Elastic Search                                                                                       | Efficient retrieval and indexing of unstructured data.                                                                                                   |

### Scalability

| **Aspect**            | **Technologies**                                                                                       | **Specifications**                                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Horizontal Scaling** | Azure Kubernetes Service (AKS)                                                                        | Scale microservices horizontally based on load.                                                                                                          |
| **Load Balancing**    | Azure Load Balancer                                                                                    | Distribute traffic across instances.                                                                                                                     |
| **Distributed Processing** | Azure Databricks                                                                                  | Use for distributed data processing and analysis.                                                                                                        |

### Trigger Mechanisms

| **Aspect**            | **Technologies**                                                                                       | **Specifications**                                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Event-Driven Architecture** | Azure Functions, Azure Event Grid                                                             | Handle various triggers using serverless functions and event grid.                                                                                       |
| **API Gateway**       | Azure API Management                                                                                   | Manage and secure APIs.                                                                                                                                  |
| **Webhook Integration** | Webhooks                                                                                             | Listen for specific events and invoke data ingestion processes.                                                                                          |



## How to Run the Project

### Prerequisites

- Java JDK 11+
- Node.js
- Docker
- Azure CLI
- Kubernetes CLI (kubectl)
- Maven

### Steps

1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-repo/hps-product.git
    cd hps-product
    ```

2. **Build the backend services:**
    ```bash
    cd backend
    mvn clean install
    ```

3. **Build the frontend application:**
    ```bash
    cd frontend
    npm install
    npm run build
    ```

4. **Dockerize the services:**
    ```bash
    cd ..
    docker-compose build
    ```

5. **Deploy to Kubernetes:**
    ```bash
    kubectl apply -f kubernetes/
    ```

6. **Access the application:**
    Open your browser and navigate to `http://<your-kubernetes-cluster-ip>`

## Glossary of Terms

| **Term**                 | **Definition**                                                                                     |
|--------------------------|-----------------------------------------------------------------------------------------------------|
| **ETL (Extract, Transform, Load)** | A process in data warehousing responsible for pulling data out of the source systems and placing it into a data warehouse. |
| **Microservices**        | An architectural style that structures an application as a collection of loosely coupled services.   |
| **Kafka**                | A distributed streaming platform used to build real-time data pipelines and streaming applications.  |
| **Serverless Computing** | A cloud-computing execution model where the cloud provider dynamically manages the allocation of machine resources. |
