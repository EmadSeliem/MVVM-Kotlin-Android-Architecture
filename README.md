# MVVM-Kotlin-Android-Architecture
MVVM + Kotlin + Retrofit2 + Hilt + Coroutines + LiveData+Data Binding

## Getting Started
In this tutorial, we are going to learn about the MVVM architecture in Android,I created sample projcet for getting COVID19 statistics per country.


<img src="https://user-images.githubusercontent.com/17107040/115163433-229ce180-a0ba-11eb-9d26-95f14ad3e181.png" width="400" height="790">

## What is MVVM architecture?
( MVVM )architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component. 

- Model:
It represents the data and the business logic of the Android Application. It consists of the business logic - local and remote data source, model classes, repository.

- View:
It consists of the UI Code(Activity, Fragment), XML. It sends the user action to the ViewModel but does not get the response back directly. To get the response, it has to subscribe to the observables which ViewModel exposes to it.

- ViewModel:
It is a bridge between the View and Model(business logic). It does not have any clue which View has to use it as it does not have a direct reference to the View. So basically, the ViewModel should not be aware of the view who is interacting with. It interacts with the Model and exposes the observable that can be observed by the View.

mvvm.png![image](https://user-images.githubusercontent.com/17107040/115162429-84f2e380-a0b4-11eb-926e-b2b8ca78fc26.png)

## Data Binding
Declaratively bind observable data to UI elements.

## LiveData
Is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components.

## Dagger-Hilt
Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project,
Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness.

## Coroutines
A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.




