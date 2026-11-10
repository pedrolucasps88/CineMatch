# CineMatch 🎬

**Discover what to watch. Find what you love.**

CineMatch is a web application designed to make movie and TV show discovery easier, more interactive, and personalized.

The project aims to help users explore audiovisual content, express their preferences, receive recommendations, and organize titles they want to watch — all within a single platform.

Rather than simply displaying large catalogs of movies and shows, CineMatch focuses on the discovery experience. Users will be able to interact with recommendations, evaluate titles, and gradually build a personalized collection based on their interests.

The project is currently under active development, starting with its core individual-user experience and designed with room for future expansion.

---

## 📌 Table of Contents

- [Project Overview](#-project-overview)
- [Vision and Objectives](#-vision-and-objectives)
- [Core Features](#-core-features)
- [Future Possibilities](#-future-possibilities)
- [Architecture](#-architecture)
- [Technology Stack](#-technology-stack)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Development Roadmap](#-development-roadmap)
- [Project Status](#-project-status)

---

## 🎯 Project Overview

Choosing something to watch can become surprisingly difficult when there are thousands of movies and TV shows available across different platforms.

Users often spend more time searching, comparing ratings, reading descriptions, and discussing options than actually deciding what to watch.

CineMatch addresses this problem by bringing together three main concepts:

- **Discovery:** Explore movies and TV shows through an interactive recommendation experience.
- **Personalization:** Build recommendations around individual preferences and previous interactions.
- **Organization:** Keep track of interesting titles in a personal watchlist.

The initial development focuses on creating a functional MVP (Minimum Viable Product), establishing a reliable foundation before introducing more advanced features.

## 💡 Vision and Objectives

The main objective is to develop a platform where discovering something to watch becomes a simple and enjoyable experience.

CineMatch is built around the following principles:

- **Personalized experience:** Recommendations should reflect each user's interests rather than relying exclusively on generic popularity rankings.
- **Simple interaction:** Users should be able to express their preferences quickly and intuitively.
- **Persistent information:** User accounts, evaluations, and personal lists should remain available between sessions.
- **Modular architecture:** The application should be organized in a way that makes future maintenance and expansion easier.
- **Scalability of ideas:** The initial implementation should provide a foundation for more sophisticated recommendation systems and social features.

## ✨ Core Features

The following features define the initial product scope.

| Feature | Description |
|---|---|
| User Authentication | Create an account and securely access a personal profile. |
| Movie & TV Show Search | Search for titles and retrieve their available information. |
| Title Details | Display information such as posters, release year, genres, synopsis, and ratings. |
| Interactive Evaluation | Approve or reject titles through a card-based interface. |
| Personalized Recommendations | Suggest titles based on previously approved genres and user evaluation history. |
| Personal Watchlist | Save interesting titles and manage the collection of movies and shows to watch. |
| Data Persistence | Preserve user accounts, evaluations, and personal lists between sessions. |

### Recommendation Approach

The initial recommendation mechanism will use explicit rules rather than machine learning.

Approved titles will help identify the genres that interest a user. These preferences will then be used to prioritize similar titles while excluding those that have already been evaluated.

This approach provides a transparent and testable starting point, allowing the recommendation logic to evolve as the project develops.

## 🚀 Future Possibilities

CineMatch is designed to go beyond individual recommendations.

After the initial MVP, the platform may evolve into a more social discovery experience.

Potential future features include:

- **Group Discovery:** Create groups with friends and explore titles together.
- **Shared Preferences:** Identify movies and shows that appeal to multiple users.
- **Group Matching:** Find titles that receive positive evaluations from everyone in a group.
- **Friends and Invitations:** Connect users and create shared discovery sessions.
- **Advanced Recommendations:** Introduce more sophisticated recommendation techniques as the available data grows.
- **Enhanced User Profiles:** Allow users to configure preferred genres, languages, and content types.
- **Responsive Experience:** Improve usability across desktop and mobile devices.

These possibilities are part of the project's long-term vision and are not commitments for the initial MVP.

## 🏗️ Architecture

CineMatch follows a **client-server architecture**, organized around the MVC pattern and a layered backend structure.

The frontend and backend are maintained as separate projects within a single Git repository (monorepo).

### Backend Layers

| Layer | Responsibility |
|---|---|
| Controller | Handle HTTP requests, validate input, and return responses. |
| Service | Implement business rules, recommendation logic, and application operations. |
| Repository | Manage communication with the database. |
| Model / Entity | Represent the application's domain objects and persistent data. |

The frontend communicates with the backend through HTTP requests and JSON responses.

The backend is responsible for application logic, database operations, authentication, and communication with external services.

This separation keeps the frontend independent of database access and prevents private API credentials from being exposed in the browser.

## 🛠️ Technology Stack

The following technologies have been selected for the project.

### Backend

- **Java 25** — Main programming language.
- **Spring Boot 4.1.2** — Backend application framework.
- **Spring Web** — REST API development.
- **Maven** — Dependency management and build automation.
- **Spring Data JPA / Hibernate** — Object-relational mapping (planned).
- **SQLite** — Relational database for the initial MVP.

### Frontend

- **HTML5** — Application structure.
- **CSS3** — Styling and visual presentation.
- **JavaScript** — Client-side behavior and backend communication.

### External Services

- **OMDb API** — External source of movie and TV show information, including posters, descriptions, release years, and other available metadata.

### Development Tools

- **Git** — Version control.
- **GitHub** — Source code hosting and project management.
- **JUnit** — Unit and integration testing.

Technology versions and dependencies may evolve as implementation and compatibility testing progress.


## ⚙️ Getting Started

### Prerequisites

Before running the project, make sure you have:

- Java Development Kit (JDK) 25.
- Git.
- A code editor or IDE (IntelliJ IDEA, VS Code, or equivalent).

Maven is managed through the project's Maven Wrapper, so a separate Maven installation is not required.

### 1. Clone the Repository

```bash
git clone <REPOSITORY_URL>
cd CineMatch
```

### 2. Run the Backend

Navigate to the backend directory:

```bash
cd cinematch-backend
```

Run the application using Maven Wrapper:

**Windows:**

```bash
mvnw.cmd spring-boot:run
```

**Linux / macOS:**

```bash
./mvnw spring-boot:run
```

The Spring Boot application currently runs on:

```text
http://localhost:8080
```

At this stage, the backend environment has been initialized. Application endpoints and business functionality are still being developed.

### 3. Frontend

The frontend is maintained separately in the `cinematch-frontend` directory.

Its interface and integration with the backend will be developed incrementally.

### 4. Environment Configuration

External API credentials will be managed through environment variables or local configuration files excluded from version control.

For example, the planned OMDb integration will use:

```text
OMDB_API_KEY=your_api_key
```

Never commit private API keys, passwords, or other sensitive credentials to the repository.

## 🗺️ Development Roadmap

Development is organized incrementally, prioritizing the functionality required for the MVP.

| Stage | Main Objective | Status |
|---|---|---|
| 1 | Requirements, repository, and initial architecture | Completed |
| 2 | Spring Boot environment and project structure | In Progress |
| 3 | Database configuration and backend persistence | Planned |
| 4 | User registration and authentication | Planned |
| 5 | OMDb API integration and title search | Planned |
| 6 | Frontend development and backend integration | Planned |
| 7 | Evaluation system and recommendation logic | Planned |
| 8 | Personal watchlist | Planned |
| 9 | Testing, improvements, and MVP completion | Planned |

The roadmap is a working reference rather than a fixed development sequence. Tasks and priorities may change as implementation progresses.

## 📊 Project Status

<sub>Early development — MVP implementation in progress.</sub>

CineMatch is currently in its initial development phase.

The repository and initial backend environment have been established, and the implementation is progressing toward the first functional version.

Core application features, database integration, external API communication, and the frontend are still under development.

This README will be updated as the project evolves, reflecting architectural decisions, implemented functionality, setup instructions, and future improvements.

---

**CineMatch** — Making the next movie night easier to decide.