# MVVM-Kotlin-Android-Architecture
MVVM + Kotlin + Retrofit2 + Hilt + Coroutines + LiveData+Data Binding

## Getting Started
In this tutorial, we are going to learn about the MVVM architecture in Android,I created sample projcet for getting COVID19 statistics per country.

## What is MVVM architecture?
Model-View-ViewModel ( MVVM )architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component. 

- Model:
It represents the data and the business logic of the Android Application. It consists of the business logic - local and remote data source, model classes, repository.

- View:
It consists of the UI Code(Activity, Fragment), XML. It sends the user action to the ViewModel but does not get the response back directly. To get the response, it has to subscribe to the observables which ViewModel exposes to it.

- ViewModel:
It is a bridge between the View and Model(business logic). It does not have any clue which View has to use it as it does not have a direct reference to the View. So basically, the ViewModel should not be aware of the view who is interacting with. It interacts with the Model and exposes the observable that can be observed by the View.

mvvm.png![image](https://user-images.githubusercontent.com/17107040/115162429-84f2e380-a0b4-11eb-926e-b2b8ca78fc26.png)
