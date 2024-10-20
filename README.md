# Rock Paper Scissors Game 🎮

A simple web application to play rounds of Rock, Paper, Scissors. Built with Java 17, Maven, Spring Boot, and Thymeleaf. The application supports multiple users playing independently, maintains global statistics, and includes unit tests with JUnit.

## Features

- **Play Rounds**: Automatically play rounds where Player 1 chooses randomly and Player 2 always chooses Rock.
- **User Session Tracking**: Each user has their own game session, including round count and history.
- **Global Statistics**: View total rounds played, wins for each player, and draws across all users.
- **Restart Game**: Reset your game session without affecting global statistics.

## Technologies Used

- Java 17
- Maven
- Spring Boot
- Spring Web
- Thymeleaf
- JUnit 5

## Project Structure

```plaintext
rps/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/rps/
    │   │       ├── RpsApplication.java
    │   │       ├── controller/
    │   │       │   └── GameController.java
    │   │       ├── model/
    │   │       │   ├── Move.java
    │   │       │   ├── RoundResult.java
    │   │       │   └── GlobalStats.java
    │   │       └── service/
    │   │           └── GameService.java
    │   └── resources/
    │       └── templates/
    │           ├── game.html
    │           └── stats.html
    └── test/
        └── java/
            └── com/example/rps/
                └── service/
                    └── GameServiceTest.java
```
## Requirements

- Java 17
- Maven

## Setup and Running the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/EddieRivers/rps.git
   cd rps
   ```
2. **Build the Project**

   ```bash
   mvn clean install
   ```
3. **Run the Application**

   ```bash
   mvn spring-boot:run
   ```
The application will start on http://localhost:8080/.

## Using the Application

- **Play a Round**

  Visit `http://localhost:8080/` and click on the **"Play Round"** button to play an automatic round.

- **View Round History**

  The page displays the number of rounds played and a table showing each round's details.

- **Restart Game**

  Click on the **"Restart Game"** button to reset your session's round count and history.

- **View Global Statistics**

  Click on the **"View Global Statistics"** link to see the total rounds played, total wins for each player, and total draws across all users.

## Running Tests

Execute the following command to run the unit tests:

```bash
mvn test
```
## Notes

- The application uses `HttpSession` to maintain user sessions, allowing multiple users to play independently.
- Global statistics are stored in memory using `GlobalStats` and are thread-safe with `AtomicInteger`.
- No database is used; all data is stored in memory and will reset when the application restarts.

## License

This project is open-source and available under the MIT License.
