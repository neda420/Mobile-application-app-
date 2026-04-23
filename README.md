# Mobile-application-app-

All assignments for Mobile App Development, combined into a single production-ready Android app.

---

## Branch Overview

| Branch | Folder | Feature |
|---|---|---|
| `Assignment-1` | `Assignment13/` | Counter app (Toast + click counter) |
| `Assignment-2` | `ToDoListApp/` | To-Do List app (add/remove tasks) |
| `Assignment-3` | `WeatherApp/` | Weather app (OpenWeatherMap API + Retrofit2) |
| `Midterm-project` | `Calculator2/` | Calculator app (+, -, *, /, parentheses) |

---

## Combined Production App — `MobileApps/`

All four projects have been merged into a single Android app located in the **`MobileApps/`** folder.

### Features
- **Home screen** — navigates to each of the four mini-apps
- **Counter** (Assignment 1) — Toast message + click counter
- **To-Do List** (Assignment 2) — Add and long-press-delete tasks
- **Weather** (Assignment 3) — Fetch live weather by city via OpenWeatherMap
- **Calculator** (Midterm) — Basic arithmetic with operator precedence and parentheses

### Technical details
- Language: **Java**
- Min SDK: **26** (API 26+, covers all four original projects)
- Target / Compile SDK: **34**
- Build tooling: **Gradle 8.7.1** with Kotlin DSL (`build.gradle.kts`)
- Dependencies: AndroidX AppCompat, Material3, ConstraintLayout, Retrofit2 + Gson
- **Production build**: `isMinifyEnabled = true`, `isShrinkResources = true`, ProGuard rules for Retrofit/Gson

### How to build
```bash
cd MobileApps
./gradlew assembleRelease   # production APK (minified + shrunk)
./gradlew assembleDebug     # debug APK
```

The release APK will be output to `MobileApps/app/build/outputs/apk/release/`.
