package com.andreasjakl.partslist

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface PartsApiClient {
    @GET("parts") fun getPartsAsync(): Deferred<Response<List<PartData>>>
    @POST("parts") fun addPartAsync(@Body newPart : PartData): Deferred<Response<Void>>
    @DELETE("parts/{id}") fun deletePartAsync(@Path("id") id: Long) : Deferred<Response<Void>>
    @PUT("parts/{id}") fun updatePartAsync(@Path("id") id: Long, @Body newPart: PartData) : Deferred<Response<Void>>
}