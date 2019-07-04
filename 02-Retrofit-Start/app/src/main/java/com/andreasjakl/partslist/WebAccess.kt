package com.andreasjakl.partslist

// Singleton pattern in Kotlin: https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations
object WebAccess {
    // TODO uncomment following line
    //val partsApi : PartsApiClient by lazy {

        // TODO Create local variable with Retrofit.Builder()

                // TODO add .baseUrl to the call
                // If working with a local server on your PC and want to access
                // it from the emulator, use http://10.0.2.2:3000

                // TODO add Moshi to the builder as converter factory
                // use: MoshiConverterFactory.create()

                // TODO add the Coroutine call adapter factory
                // use: CoroutineCallAdapterFactory()

                // TODO use build() to finalize the builder process


        // TODO uncomment the following line to create Retrofit client
        // return@lazy retrofit.create(PartsApiClient::class.java)

}