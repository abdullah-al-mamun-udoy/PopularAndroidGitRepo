This project fetches and displays popular Android repositories from GitHub using the GitHub API. It is built using Jetpack Compose, Room Database, Hilt for Dependency Injection, and Kotlin Coroutines.

*Features

Fetches Android repositories sorted by stars

Displays repository details including name, owner, description, stars, and forks

Caches repository data using Room Database

Implements Hilt for dependency injection

Handles API states (Loading, Success, Error)

*Tech Stack

Kotlin

Jetpack Compose

Retrofit for network calls

Room Database for local caching

Hilt for Dependency Injection

Flow & StateFlow for reactive data handling

*Installation

Prerequisites

Android Studio (latest version recommended)

Minimum SDK version: 26

Target SDK version: 35

*API Integration
The app fetches repository data from the GitHub API:

GET https://api.github.com/search/repositories?q=Android&sort=stars&order=desc&per_page=20

Uses Retrofit and Coroutines for asynchronous network calls.

*Room Database

Stores repositories locally for offline access.

Uses @Entity, @Dao, and @Database annotations for data persistence.

TypeConverters are required for non-primitive data types like lists.

*State Management

Resource<T> class is used to manage Success, Error, and Loading states.

StateFlow is used in ViewModel to observe data changes in a reactive way.

*Dependency Injection with Hilt

@HiltViewModel is used in ViewModels for DI.

@Module and @InstallIn(SingletonComponent::class) are used for dependency provisioning.

*Future Improvements

Implement Pagination for large dataset handling

Improve Error Handling for better user experience
