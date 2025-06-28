# Audiobooks Coding Challenge

This is a simple Android app that shows a list of podcasts. Users can view details of each podcast and mark them as favourite. Favourite items are saved locally so the app remembers them even after closing.

## Features

- Show a list of podcasts using paging
- View podcast details on a new screen
- Mark or unmark a podcast as favourite
- Favourite state is saved in local database
- Simple navigation and UI using Jetpack Compose

## Tech Stack

- Jetpack Compose
- Paging 3
- Room database
- Retrofit
- Hilt
- MVVM with clean architecture

## Project Structure

- `data`: DTOs, Room database, repository implementation
- `domain`: App models and use cases
- `presentation`: ViewModels and Compose screens
- `di`: Dependency injection with Hilt
- `navigation`: App navigation setup

## Notes

- Code is written in a simple and clean way
- Favourite podcasts are saved using Room
- Paging is used for smooth scrolling
- Screens are built using Jetpack Compose
- State updates and data flows are handled properly
