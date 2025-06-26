# RedditNews

RedditNews is a modular Android application built using **Clean Architecture** and the **MVI (Model–View–Intent)** pattern. It showcases how to build scalable, testable, and maintainable Android apps with modern tools and best practices.

---

## 🚀 Features

- Fetches and displays Reddit news posts.
- Implements a robust MVI state management flow.
- Modularized for scalability and clean separation of concerns.
- Built with Kotlin, Jetpack Compose, and coroutines.

---

## 🧱 Architecture

The app is built using **Clean Architecture** with a strict unidirectional data flow based on the MVI pattern.

### 🔁 MVI Flow

- **Intent**: Represents user actions.
- **ViewModel**: Interprets intents, calls use cases, and emits UI states.
- **State**: Immutable representation of the UI at any point.
- **Reducer**: Transforms the previous state and the result of an intent into a new state.

---

## 📦 Module Breakdown

| Module        | Responsibility |
|---------------|----------------|
| `app`         | App entry point, sets up navigation and DI. |
| `core`        | Shared utilities and common components. |
| `data`        | Remote data source (e.g., Retrofit), repository implementations. |
| `domain`      | Use cases and repository interfaces (business logic). |
| `presentation`| ViewModels, state, UI layers using Jetpack Compose. |

---

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: Clean Architecture, MVI
- **Dependency Injection**: Hilt
- **Networking**: Retrofit, OkHttp
- **State Management**: StateFlow, ViewModel
- **Coroutines**: For async operations
- **Testing**: JUnit, MockK (if used)
- **Gradle Plugin**: `androidGradlePlugin = 8.1.1`
- **IDE**: Android Studio Narwhal | 2025.1.1+
---

## 🧪 Setup Instructions

1. **Clone the repo**
   ```bash
   git clone https://github.com/basemomar94/RedditNews.git
   cd RedditNews

