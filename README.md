# RestApi's Using SpringBoot and MongoDB

## Requirements
1. Java jdk
2. mongodb
3. gradle
4. postman

## How  to Run
open the project folder in terminal
> gradle build

> gradle bootrun
## Endpoints
> GET  
>1.  /users - to get all users
>2.  /users/{id} - to get user of specific id

> POST
> /createuser  (set Content-type as application/json)

> Update
> /updateuser/{id} (set Content-type as application/json)

> Delete
> /deleteuser/{id}