# Spring Boot Tutorial from Amigoscode

[Amigoscode tutorial video](https://www.youtube.com/watch?v=9SGDpanrc8U&t=4081s)

## To run the project, first you need to:
- Create a db folder in the root of this folder
- Run docker-compose up -d
- Run docker exec -it postgres_sgbd psql -U postgres
- Create a database called demo_dev

## Project structure
The project has the folders:
- controllers: controllers are responsible for the routing of an endpoint
- models: models are responsible for modeling the database table
- repositories: repositories are responsible for accessing, deleting, creating and updating data from the database
- services: services are responsible for the business logic