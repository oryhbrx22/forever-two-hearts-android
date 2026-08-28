# Forever Two Hearts - Android App

Android Kotlin implementation of the Forever Two Hearts app using Jetpack Compose, Supabase, and Room Database.

## Architecture

This project follows the MVVM (Model-View-ViewModel) architecture pattern:

- **UI Layer**: Jetpack Compose for modern declarative UI
- **ViewModel Layer**: Manages UI state and business logic
- **Repository Layer**: Abstraction for data sources
- **Data Layer**: Local database (Room) and remote API (Supabase)

## Tech Stack

- **Kotlin**: Primary language
- **Jetpack Compose**: Modern UI toolkit
- **Room Database**: Local SQLite database
- **Supabase**: Backend-as-a-Service (Authentication, Database, Realtime)
- **Ktor Client**: HTTP client for API communication
- **Kotlin Flow**: Reactive programming
- **Material Design 3**: UI design system

## Setup

### Prerequisites

- Android Studio 2023.1 or higher
- Kotlin 1.9.22+
- Android API level 24+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/oryhbrx22/forever-two-hearts-android.git
   cd forever-two-hearts-android
   ```

2. Create a `local.properties` file in the root directory (if not present):
   ```
   sdk.dir=/path/to/android/sdk
   ```

3. Update Supabase credentials in `src/main/kotlin/com/foreverhearts/app/data/remote/SupabaseClient.kt`:
   ```kotlin
   private const val SUPABASE_URL = "your-supabase-url"
   private const val SUPABASE_KEY = "your-supabase-anon-key"
   ```

4. Build and run:
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

## Project Structure

```
src/main/kotlin/com/foreverhearts/app/
├── ui/
│   ├── screens/
│   │   ├── home/
│   │   ├── auth/
│   │   └── profile/
│   ├── navigation/
│   └── theme/
├── data/
│   ├── database/
│   │   ├── dao/
│   │   └── entities/
│   ├── remote/
│   └── repository/
└── domain/
    └── usecase/
```

## Features

- ✅ User Authentication (Supabase Auth)
- ✅ User Profiles
- ✅ Local Data Persistence (Room)
- ✅ Real-time Updates (Supabase Realtime)
- ✅ Material Design 3 UI
- ✅ Navigation (Jetpack Navigation Compose)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

MIT License - see LICENSE file for details