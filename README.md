# Flight Ticket Booking System

## Demo Images
![Screenshot](screenshot.png)

## Introduction
This project was created for learning microservices architecture. Where the functionalities 
coded in project are, searching for flights based on origin and destination, creating users,
booking a ticket using flight id and userid. A simple UI is also developed, which makes ajax calls
to api gateway and then api gateway forwards it to appropriate microservice, and resulting data is
displayed on the UI.

## Following are the microservices
### Flight Details
#### Endpoints covered
1. /add flight
2. /delete/{flight-id}/
3. /updateFlight
4. /update-source/{flight-id}/newSource
5. /update-destination/{flight-id}/newDestination
6. /update-Name/{flight-id}/newName

### User Details
#### Endpoints covered
1. /get/{user-id}
2. /user/getall
3. /user/add
/4. delete/{user-id}
5. /update-name/{user-id}/newName

### Book Flight
#### Endpoints covered
1. /searchFlight/{source}/{destination}
2. /getFlightDetails/{flight-id}
3. /book-flight/{user-id}/{flight-id}/{seatType}
4. /yourBookings/{user-id}
5. /cancel-booking/{booking-id}
6. /getDetails/{booking-id}
7. /getAllFlightDetails


## Database used
Following the best practices for microservices architecture, created seperate databases for each of microservices.
1. User db
2. Flight db
3. Ticket db

## Technology Stack
1. Java
2. Spring Boot
3. REST API
4. MAVEN
5. Spring Data JPA
6. Spring Cloud
7. MySQL
8. HTML
9. CSS
10. JavaScript
