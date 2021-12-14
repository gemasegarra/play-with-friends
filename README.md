# PWF: Play with friends!

> Welcome to PWF! your app to find friends to play videogames with ☺️
![create](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/2.png)


PWF is a full stack app made with Angular, Bulma and Spring Boot & MySQL

## Main features:

- Users can create an account and login
![login](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/4.png)

- Main page shows a list of multiplayer games that can be filtered by type 
![games](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/3.png)

- Logged users can create matching requests for the games in the database to look for people to play with
![create](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/2.png)


- Logged user can see a list of the active matching requests and join if the wish
![match](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/1.png)

- An email is send to the creator of the matching request when someone joins
![email](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/5.png)


- Users have a profile where they can see the matches they joined or created 
![profile](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/Sin%20t%C3%ADtulo.gif)


## ⚙️ Project setup:
To run this project locally do the following after cloning it:

### Frontend:
Run ```npm i to install``` node dependencies
Run ```ng serve``` to start project on localhost:4200


### Backend:

The backend app is split into the following microservices:

![microservices](https://github.com/gemasegarra/play-with-friends/blob/master/frontend/src/assets/microservices.png)

Eureka service: runs on port:8761
Edge service: runs on port:8080
User service: runs on port:8081
Matching service: runs on port:8082
Games service: runs on port:8083
Email service: runs on port:8084
Auth service: runs on port:8085

**Prerrequisites:**

Don't forget to setup your own SQL server and seed the database with this SQL script. All microservices will use the same database, called demo. Make sure you have the same values you'll find in the application.properties file of each microservice or properly change them according to your configuration.

Open each service folder separately

Run ```mvn spring-boot:run```

❗️ It is important that you start first the eureka service project so the other microservices work

## API Endpoints & Documentation 📖

These are some of the endpoints of the API:

| Service | Method | Endpoint              | Response / description                                           | 
| ------ | ------ | --------------------- | -------------------------------------------------------- | 
| Games    | GET         | ```/games  ```             | shows list of all games | 
| Games    | GET         | ```/games/{id}  ```             | shows data of a specific game | 
| Games    | DELETE         | ```/games/{id}  ```             | removes specific game from db | 
| Games    | POST         | ```/games/{id}  ```             | creates game | 
| Matching    |  GET  | ```/matching```  | shows list of all matching requests  | 
| Matching    |  POST  | ```/matching```  | create new matching request  | 
| Matching    |  POST  | ```/matching/{id}```  | allows logged user to join a specific matching request  | 
| User    |  POST  | ```/users/{id}```  | allows to add description to logged user's profile  | 
| Email    |  POST  | ```/email```  | sends email to match request owner when someone joins | 

More extensive API documentation will be available *soon*

## 🛠 Build with:
- Angular
- Angular Material
- Bulma
- Eureka
- JavaMailSender
- MySQL
- Springboot

## Todo:

Please notice this project is pretty much unfinished. Lots of things need to improve!

- Code refactor (loooots of it)
- Add to the frontend app functionalities that are working on the backend (such as profile editing, add friends, add games to game list)
- Improve security wit jwt
- Password recovery service
- About page

## Made by 👩🏻‍💻

This project was made by me as a final project for the Ironhack web development bootcamp
