# PartsList
Example App: RecyclerView with Kotlin on Android

Finished source code for the blog article introducing RecyclerView with Kotlin support on Android. Follow the instructions to go from a new project in Android Studio to a fully-working RecyclerView list.

* [Part 1: Kotlin & RecyclerView for High Performance Lists in Android](https://www.andreasjakl.com/kotlin-recyclerview-for-high-performance-lists-in-android/)
* [Part 2: How To: RecyclerView with a Kotlin-Style Click Listener in Android](https://www.andreasjakl.com/recyclerview-kotlin-style-click-listener-android/)
* Part 3: How-To: Retrofit, Moshi, Coroutines & Recycler View for REST Web Service Operations with Kotlin for Android (coming soon)

## Example projects

* **01 Offline variant:** The finished solution for Part [1](https://www.andreasjakl.com/kotlin-recyclerview-for-high-performance-lists-in-android/) + [2](https://www.andreasjakl.com/recyclerview-kotlin-style-click-listener-android/) is in the 01-RecyclerView directory. This contains a fully working Recycler View project with a click listener written in Kotlin. It uses test data added during onCreate().
* **02 + 03 Web Service variant:** Part 3 of the article series added dynamically retrieving and updating data through a REST web service. Find the starter project in 02-Retrofit-Start; the article walks you through the implementation steps. The final solution of the recycler view project with added web access is in 03-Retrofit-Solution.

**Mock Server** for examples 02/03: find details how to install and run the local mock server for parts 2 + 3. Short summary:

 1. Install Node.js
 2. Install the json-server module globally: `npm install -g json-server`
 3. Run the server from the root directory of this repository, which contains the sample database (db.json): `json-server --watch db.json`

## Related Information

Released under the Apache License, Version 2.0 - see the LICENSE file for details.

Developed by Andreas Jakl
* https://www.andreasjakl.com/
* https://twitter.com/andijakl
