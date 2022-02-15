# Challenge Movie Theater

## Command

`./mvnw install -Dmaven.test.skip && ./mvnw spring-boot:run -pl delivery`

(tested with java 8.0.272-amzn)

## Tech Stack

Kotlin using clean architecture,as it's my first project in Kotlin and my first attempt to implement the clean architectue I used this project as a starting point: (based on:  https://github.com/thecodegang/clean-architecture-example).
We use spring boot, resttemplate(okhttpclient), jpa/hibernate.

I didn't get the chance to use any functional library for this project.

## Architecture

we  have 4 projects, core, dataproviders (db/rest/..), delivery and usecases.
The core define the data models, then, each other project implements his own version
based on his need (db => column id,.. json => name,...), as result, we
have a lot code duplication, but that allow us to clearly separate
each concerns.

## State of the project

I was not able to do everything that I wanted, as it was my first Kotlin project,
and sometimes, I choosed to simplify some part of it, like for the movie details, I only
return the title, not all the fields, just to write less code  and win some times.
Then I  add some issue with the testing, spring-test version not compatible, then jackson,..
the jpa requiring a different configuration to load the data in the db. This is why not all
the use cases are not present.

### endpoint done:

##### /movie/{imdb}  - GET

return movie details (checking if present in our theater, then using external service). It also
contains the reviews

##### /movie/review - POST

can publish a review. like
```
curl --location --request POST 'localhost:8080/movie/review' \
--header 'Content-Type: application/json' \
--data '{"imdbID": "tt4630562", "star": 3, "userName":"john" }'
``` 

##### /showtimes/{imdb} - GET

return the showtimes for a specific movie


The other endpoins  are not present