# Fuze | Android Challenge 

The candidate must build an app that will display a list of CS: GO matches in a given period of time. For that, the [PandaScore](https://pandascore.co/) API will be used. The design spec is [here](https://www.figma.com/file/OeNVxV2YkHXMgzky8YNQQO/Desafio-CSTV?node-id=0%3A1).

## Solution and considerations 

The application is a list of CS Go matches, in addition to having a details screen that displays the team members of each team in the match.
- The list display order is taking into account the *"-status"* filter, which leads to prioritizing the most current matches.
- Much data was unavailable, so *placeholders* were adopted for images and fields that the API returned as null.

The **[MVVM architecture](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)** was adopted in accordance with [Google's mobile architecture recommendations](https://developer.android.com/jetpack/guide) along with the approaches proposed by **[Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)**. Also, the main libraries from the world of Android Jetpack and the use of other tools were adopted in the project. Below is each one with the appropriate justification for adoption:

- **[Retrofit](https://square.github.io/retrofit/) + [OkHttp:](https://square.github.io/okhttp/)** easy-to-use *type-safety* HTTP clients for Android that provide a simple implementation pattern for transmitting data between application/server that also help us "cache" information.
- **[Kotlin Coroutines + Flow:](https://developer.android.com/kotlin/flow)** a type that can emit multiple values sequentially, unlike sleep functions, which return only one value. Streams are created based on coroutines and can provide multiple values. Conceptually, a stream is a stream of data that can be computed asynchronously.
- **[Coil:](https://coil-kt.github.io/coil/)** It is an image loading library for Android supported by Kotlin Coroutines.
- **[Hilt:](https://dagger.dev/hilt/)** Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- **[Navigation:](https://developer.android.com/guide/navigation)** the Android Jetpack navigation component helps you implement navigation, from simple button clicks to more complex patterns like app bars and the navigation drawer. This component also ensures a consistent and predictable user experience through adherence to an established set of principles.
- **[Jetpack Compose:](https://developer.android.com/jetpack/compose)** Jetpack Compose is a modern Android toolkit for creating native UIs. It simplifies and speeds up UI development on Android, making code simpler and easier to maintain (avoids coding classes and *boilerplates* code). It works declaratively, which speeds up development.
- **[Paging:](https://developer.android.com/jetpack/compose)** the Paging library makes it easy to gradually and smoothly load data into your app's RecyclerView.
- **[Mockk:](https://mockk.io/)** a library for simulation written and made for Kotlin + JUnit 4 (JUnit 4 exposes a rules-based API to allow for some automation after the test lifecycle).

Finally, talking a little about **MVVM (Model-View-ViewModel)**, we basically divide it into:

- **Model:** the layer that encapsulates business logic and data. It is nothing more than the domain model of an application.
- **View:** is responsible for defining the appearance or structure that the user sees on the screen. This is the entire visual part of the application.
- **ViewModel:** Its task is to provide presentation logic to the *View* layer. The *ViewModel* does not have any specific knowledge about the view, it only implements properties and commands and notifies the *View* in case of changes. It allows data to survive configuration changes, such as screen rotation, for example.

Considering these layers, we can observe that it is a division that fits directly with the **Clean Architecture**, which consists of a layer diagram, where each of its components has its own responsibilities and each of them has knowledge only of layers more internal. This brings with it several advantages:

- the code is easily testable.
- even more decoupled components, the package structure is easily navigated between them.
- new features can be added quickly by the development team.

Each layer of MVVM using Clean Architecture in Android and the codes are divided into three layers:

- **Presentation Layer:** In this layer, the "Activity"s, "Fragment"s as "Views", and the "ViewModel"s are included, they should be as simple and intuitive as possible and Furthermore, business rules should not be included in "Activity"s and "Fragment"s. A "View" will communicate with its respective "ViewModel", and thus, the "ViewModel" will communicate with the domain layer to perform certain actions. A "ViewModel" will never communicate directly with the data layer. Here, in our project structure, we have the "presentation" directories, which in turn, have the "ui" (with our "View"s and "ViewModel"s) and "di" (with our Koin module to handle the dependency injections).

- **Domain Layer:** The domain layer must contain all application use cases. The use cases are intended to be mediators between your "ViewModel"s and the "Repository"s. If it is necessary to add a new functionality, all that must be done is to add a new use case and all its respective code will be completely separate and decoupled from the other use cases. The creation of a new use case is precisely to prevent adding new functionalities from breaking pre-existing ones in the code. We can look at the "domain" directory and, within this, the "usecase" directory with all our use cases.

- **Data Layer:** This layer has all the repositories that the domain layer has available for use and "DataSource"s, which are responsible for deciding which source the data should be retrieved from, whether from a local database or remote server. Note the "data" repository. It focuses on our data models, database modeling, service layer (which lists all our endpoints), DAO layer for accessing data in the database and, part of our repositories.

This was the approach adopted in the solution. Thank you in advance.

## How to execute the project 

To clone the project, run the command

```
git clone (by SSH or HTTPS)
```
After cloning the project in the *master* branch, obtain a valid token from the [PandasCore API](https://developers.pandascore.co/reference), go to the build.gradle file (module :app) and paste your key into the API_KEY variables of the debug and release flavor (don't forget to remove the keys):
```
buildTypes {
        debug {
            // ...

            buildConfigField(
                type = "String",
                name = "API_KEY",
                value = "\"{PASTE_YOUR_TOKEN_HERE}\""
            )

           // ...
        }

        release {
            // ...

            buildConfigField(
                type = "String",
                name = "API_KEY",
                value = "\"{PASTE_YOUR_TOKEN_HERE}\""
            )

           // ...
        }
    }
```

After that, sync the project and run the app module on an emulator or physical device. You should see the app working like the images below.

![Captura de tela 2024-01-12 101143](https://github.com/lucaschristopher/fuze-challenge/assets/20783887/e3670c66-666f-4b80-b4fd-0d93928e626d)
![Captura de tela 2024-01-12 101212](https://github.com/lucaschristopher/fuze-challenge/assets/20783887/d2322a86-428c-4a64-8f74-293b406ed368)
![Captura de tela 2024-01-12 101105](https://github.com/lucaschristopher/fuze-challenge/assets/20783887/ea6e27f5-44ba-433c-9aaa-e165542f4128)
![image](https://github.com/lucaschristopher/fuze-challenge/assets/20783887/07e7b142-d754-4f69-895f-da152c6d4242)





**Autor: Lucas Christopher.**

##### _All honor and all glory, everything comes from him and everything is for him: JESUS!_
