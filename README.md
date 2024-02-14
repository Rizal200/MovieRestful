# MovieRestful
Build Restful API Movie using spring boot, hibernate, validation, JPA, unit test

# Setup

**1. Clone the application**
```bash
git clone https://github.com/Rizal200/MovieRestful.git
```

**2. Create database**
```bash
run src/main/resources/movie.sql
```

**3. Run App Using Maveb**
```bash
$ mvn spring-boot:run
```
or using
``` bash
$ ./mvnw spring-boot:run
```

## Explore Rest APIs

### Movies

| Method | Url | Description |
| ------ | --- | ----------- | 
| GET    | /Movies | Get all Movies |
| GET    | /Movies/{id} | Get all Movies by id | 
| POST    | /Movies | Add Movie | 
| PATCH    | /Movies/{id} | Update Movie | 
| DELETE    | /Movies/{id} | Delete Movie by id | 

test using postman

## Valid JSON Request Bodys

#### Add Movie 
```json
{
    "title": "Antman",
    "description": "Scott, a master thief, gains the ability to shrink in scale with the help of a futuristic suit. Now he must rise to the occasion of his superhero status and protect his secret from unsavoury elements",
    "rating": 7.2,
    "image": "",
    "createdAt": "2023-08-01 10:56:31",
    "updatedAt": "2024-08-13 09:30:23"
}
```

#### Update Movie
``` json
{
    "title": "Ant-Man and the Wasp: Quantumania",
    "description": "Ant-Man and the Wasp find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that pushes them beyond the limits of what they thought was possible.",
    "rating": 6.1
   
}

````











