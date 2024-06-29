# Fake Twitter Backend
## Description
This is the backend for the twitter replica website.

## Setup instructions for Backend

To set up the project you will need to:
1. Install IntelliJ IDEA or another IDE that is suitable for JDK 17.
2. Install postgreSQL.
3. Clone the project repository from GitHub.
4. Import the project into your IDE.
5. Make a postgreSQL database on your system with the following command `createdb twitter`. See the `application.properties` file for the path that the application requires to access the database 
6. Run the project.
   
## The RESTful route endpoints:

The default port the project will be run on is port 8080 but any can be used. You can access the API endpoints with the following URL **`https://localhost:{port}/{endpoint}`**. See the table below for all available endpoints.

|Controller | Mapping |Path | Description |
|----------|-----------|------|-------------|
| Comment | GET	| `localhost:8080/comments` | Get all comments
| | GET	| `localhost:8080/comments/tweet/{tweetId}` | Get all comments for a sepcific tweet
| | POST	| `localhost:8080/comments/writeComment/{userId/{tweetId}}` | Post a comment for a specific tweet using tweetID and userId
| Tweet | GET	| `localhost:8080/tweets`	| Get all tweets
| | POST	| `localhost:8080/tweets/postTweet/{userId}`	| Post a tweet for a user using the userId
| | POST	| `localhost:8080/tweets/likeTweet/{tweetId}/{userId}`	| Like a tweet and record the userId so the user can only like a tweet once
| User | GET	| `localhost:8080/users`	| Get all user details
| | POST	| `localhost:8080/users`	| Create an account for a user
| | POST	| `localhost:8080/users/authenticate`	| Check whether log-in details are correct


## Tech Stack

The technologies used for this project are:

- Intelliji IDEA, running JDK 17
- Spring Boot
- H2 Server
- Postman
- Postico

## Dependencies

The dependencies required for the project to run are:
- SpringBoot Web
- SpringBoot DevTools
- PostgreSQL
- SpringBoot Starter Data JPA
