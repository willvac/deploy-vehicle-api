# Deploy-VehiclesAPI-Project

This is a project respository where I extended the VehiclesAPI-Project that I worked on for Udacity's Java Web Developer Nanodegree Program by deploying the project.
In the VehiclesAPI-Project, I implemented a Vehicles API that communicate with separate location and pricing services. This project was built with Java and Spring Boot.
In this project, I deployed the VehiclesAPI-Project following various deployment schemes. 
The deployment schemes are as follow:
(1) Vehicles-API-Project on a single multi-container AWS Elastic Beanstalk instance (not located in repositoy)
(2) Each service in the Vehicles-API in their own single-container AWS Elastic Beanstalk instance
![alt text](https://github.com/willvac/deploy-vehicle-api/blob/master/deploy-vehicle-api-project-multiple-single-container-AWS/Deployment%20Schematic.png)
(3) Each service deployed on a Kubernetes cluster on Google's Kubernetes Engine
![alt text](https://github.com/willvac/deploy-vehicle-api/blob/master/k8s-Google%20Cloud/deployment-schematic.jpg).
