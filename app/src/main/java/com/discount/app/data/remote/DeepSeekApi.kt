package com.discount.app.data.remote

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface DeepSeekApi {

    @Headers("Content-Type: application/json")
    @POST("chat/completions")
    suspend fun chatCompletion(
        @Body request: DeepSeekRequest
    ): DeepSeekResponse
}
