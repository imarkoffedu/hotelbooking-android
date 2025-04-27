# Hotel booking - Jetpack Compose

## Description

A simple Jetpack Compose application for managing [hotelbooking REST API](https://github.com/imarkoffedu/hotelbooking-spring/).

Code here is not as clear as in backend implementation. Sorry about that.

## Technologies

- Jetpack Compose
- Koin
- Ktor
- MVVM (almost)

## Running the application (LAN)

1. Run [hotelbooking REST API](https://github.com/imarkoffedu/hotelbooking-spring/).
2. Determine local IP address of a PC where API runs on.
3. Go to `app/build.gradle.kts` and change IP in BASE_URL.
4. Build and run the application.

## Project structure

| Directory            | Description                                |
|----------------------|--------------------------------------------|
| core/di              | Koin dependencies resolver                 |
| core/utils           | Some helper functions                      |
| data                 | Data layer                                 |
| data/api             | hotelbooking API handlers                  |
| data/dto             | Data transfer objects gotten from API      |
| data/repository      | Repository implementations for data layer  |
| domain/model         | Models used in the app                     |
| domain/repository    | Repository interfaces for data layer       |
| presentation         | Presentation layer                         |
| presentation/common  | Common UI components or composable helpers |
| presentation/main    | Main screen                                |
| presentation/booking | Booking screen and its components          |
| presentation/user    | User screen and its components             |
| ui/navigation        | Navigation handlers                        |

Unit and integration tests are not implemented here.
UseCase also not implemented.