# How People Shop (HPS) Product - Technical Assignment

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
2. [Components Communication Flow](#sequence-diagram)
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
7.  [Challenges/Concerns and Resolutions](#challengesconcerns-and-resolutions)
8.  [Coffee Consumption Calculation](#coffee-consumption-calculation)
9.  [How to Run the Project](#how-to-run-the-project)
8.  [Contact](#contact)

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
| **Customer Experience Insights**      | Stores insights related to customer experiences.       
| **Product Insights**      | Stores insights related to product clusters and their triggers.                                     |
#### Sample Queries:
| Query Description                          | SQL Query                                                                                               |
|--------------------------------------------|---------------------------------------------------------------------------------------------------------|
| Retrieve Product Insights                   | ```SELECT pi.id AS insight_id, pc.name AS product_cluster, t.type AS trigger_type, pi.insight FROM product_insights pi JOIN product_clusters pc ON pi.product_cluster_id = pc.id JOIN triggers t ON pi.trigger_id = t.id;``` |
| Retrieve Customer Experiences              | ```SELECT ce.id AS experience_id, c.name AS customer_name, n.type AS need_type, m.type AS mission_type, tp.type AS touchpoint_type, jp.phase AS journey_phase, pp.type AS place_of_purchase FROM customer_experiences ce JOIN customers c ON ce.customer_id = c.id JOIN needs n ON ce.need_id = n.id JOIN missions m ON ce.mission_id = m.id JOIN touchpoints tp ON ce.touchpoint_id = tp.id JOIN journey_phases jp ON ce.journey_phase_id = jp.id JOIN places_of_purchase pp ON ce.place_of_purchase_id = pp.id;``` |
| Retrieve Customer Experience Insights      | ```SELECT cei.id AS insight_id, ce.id AS experience_id, cei.insight FROM customer_experience_insights cei JOIN customer_experiences ce ON cei.customer_experience_id = ce.id;``` |


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

## Challenges/Concerns and Resolutions

| Concern                                                  | Resolution                                                                                                   |
|----------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| **API Gateway Performance and Reliability**               | Implement load balancing, auto-scaling, and comprehensive monitoring. Perform regular stress testing.         |
| **Security and Access Control**                          | Use Azure Active Directory for role-based access control. Regularly audit permissions and use Azure Key Vault for sensitive information. |
| **Scalability of Back-End Services**                     | Implement horizontal scaling using Kubernetes auto-scaling features. Monitor resource allocation using Prometheus and Grafana. |
| **Observability and Monitoring**                         | Integrate Elastic Search, Prometheus, and Grafana for logging, monitoring, and visualization. Set up alerts for anomalies. |
| **Data Consistency and Integrity**                       | Use data synchronization mechanisms and Azure Synapse Analytics. Perform regular data integrity checks and backups. |
| **Deployment and CI/CD**                                 | Use Azure Pipelines for automated CI/CD processes. Implement Helm for managing Kubernetes deployments and ensure rollback mechanisms. |
| **Autoscaling Complexity**                               | Configure Kubernetes autoscaling policies carefully. Monitor the interactions between different services.       |
| **Inter-Service Communication**                          | Implement robust inter-service communication mechanisms. Consider using a service mesh like Istio for traffic management and monitoring. |

## Coffee Consumption Calculation

Assuming each member of the HPS product team consumes a certain number of cups of coffee each day and knowing the length of the sprint and team size, we can calculate the total coffee consumption.

Let's define some variables:

- Number of team members = 10 (assumption)
- Cups of coffee per person per day = 3 (assumption)
- Number of working days per sprint = 10 (2-week sprint)

Total coffee consumption per sprint:

Total Coffee Consumption = Number of team members × Cups of coffee per person per day × Number of working days per sprint

Total Coffee Consumption = 10 × 3 × 10 = 300 cups

The HPS product team consumes 300 cups of coffee each sprint.


## How to Run the Project

### Prerequisites

- Java JDK 17+
- Docker
- Maven

### Steps


## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/r0jjames/IKEA-How-People-Shop-Project.git
    cd customers-experience
    ```

2. Build the project:
    ```bash
    ./mvnw clean install
    ```

3. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```
4. The application uses OpenAPI (Swagger) for API documentation. Once the application is running, you can access the documentation UI at: http://localhost:8080/swagger-ui.html

## API Endpoints

### Product Insights

Retrieve insights on how people shop for different product clusters.

- **URL:** `/api/products/insights`
- **Method:** `GET`
- **Description:** Fetches all product insights.

#### Response

```json
[
    {
        "id": 1,
        "productClusterId": 1,
        "triggerId": 1,
        "insight": "Quick Pickers are highly influenced by price reductions during sales events."
    },
    {
        "id": 2,
        "productClusterId": 2,
        "triggerId": 2,
        "insight": "Storage Solvers see an increase in demand during the back-to-school season."
    }
    ...
]
```
### Customer Insights
Retrieve insights on customer experiences.
- **URL:** `/api/customers/insights`
- **Method:** `GET`
- **Description:** Fetches all customer experience insights.

#### Response

```json
[
    {
        "insight": "Customer found the online browsing experience seamless and intuitive."
    },
    {
        "insight": "Customer felt overwhelmed by too many options at the store."
    }
    ...
]
```

### Customer Experiences
Retrieve details on customer experiences.
- **URL:** `/api/customers/experiences`
- **Method:** `GET`
- **Description:** Fetches all customer experiences..

#### Response

```json
[
  {
    "id": 1,
    "customerId": 1,
    "customerName": "Alice Johnson",
    "needType": "Replacement",
    "missionType": "Solution Seeking",
    "touchpointType": "Brand Website",
    "journeyPhase": "Browsing",
    "placeOfPurchase": "Store"
  },
  {
    "id": 2,
    "customerId": 2,
    "customerName": "Bob Brown",
    "needType": "Upgrade",
    "missionType": "Recreational Shopping",
    "touchpointType": "Store",
    "journeyPhase": "Filtering",
    "placeOfPurchase": "Online"
  },
    ...
]
```

Contact
For any inquiries or issues, please contact rojjamescarranza@gmail.com.