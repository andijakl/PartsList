package com.andresjakl.partslist

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface PartsApiClient {
    // TODO Define GET request with URL "parts".
    // Call the function getPartsAsync(). Return a List<PartData> as deferred response.


    // TODO Define POST request for the "parts" URL.
    // Function name: addPartAsync
    // The web service doesn't send a response body, so use Void (still keeping it
    // within a deferred response so that you can read the status code).
    // Send a PartData instance as parameter. Annotate it with @Body so that
    // it gets placed into the body.


    // TODO Define DELETE request with URL "parts/{id}"
    // Function name: deletePartAsync. Response similar to addPartAsync.
    // As parameter, send the id (of type Long).
    // Annotate it with @Path("id") to put the value from the parameter also into the HTTP URL.


    // TODO Define UPDATE request with URL "parts/{id}"
    // Function name: updatePartAsync. Response similar to addPartAsync.
    // As parameter, send both the id like in the DELETE function, as well as
    // a PartData object marked with @Body (similar to the POST request)
    // Annotate it with @Path("id") to put the value from the parameter also into the HTTP URL.


}