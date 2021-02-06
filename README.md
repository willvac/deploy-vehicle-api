# Deploy-VehiclesAPI-Project

In this project respository, I deploy the [VehiclesAPI-Project](https://github.com/willvac/vehicle-api-microservice-monolith) that I worked on for Udacity's Java Web Developer Nanodegree Program.

In the VehiclesAPI-Project, I implemented a Vehicles API that communicates with separate location and pricing services. The project was built with Java and Spring Boot but never deployed.

In this project, I set up a CI/CD pipeline with Travis CI to integrate, containerize, and deploy the VehiclesAPI-Project according to various deployment schemes.

The deployment schemes are as follow:
- (1) Vehicles-API-Project on a single multi-container AWS Elastic Beanstalk instance (not located in repositoy)
![alt text](https://github.com/willvac/deploy-vehicle-api/blob/master/k8s-Google%20Cloud/MulticontainerSchematic.png)
- (2) [Each service in the Vehicles-API in their own single-container AWS Elastic Beanstalk instance](https://github.com/willvac/deploy-vehicle-api/tree/master/deploy-vehicle-api-project-multiple-single-container-AWS)
![alt text](https://github.com/willvac/deploy-vehicle-api/blob/master/deploy-vehicle-api-project-multiple-single-container-AWS/Deployment%20Schematic.png)
- (3) [Each service deployed on a Kubernetes cluster on Google's Kubernetes Engine](https://github.com/willvac/deploy-vehicle-api/tree/master/k8s-Google%20Cloud)
![alt text](https://github.com/willvac/deploy-vehicle-api/blob/master/k8s-Google%20Cloud/deployment-schematic.jpg).


## Tools
The VehiclesAPI-Project was built with Java and Spring Boot.

Travis CI was used to set up a CI/CD pipeline to deploy onto AWS and Google Cloud.

Additional tools include: Dockers and Kubernetes.
