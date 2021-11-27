package com.panhuk.api

import com.panhuk.api.dto.SessionTokenResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionTokenApi {

  @GET("api_token.php")
  suspend fun getSessionToken(
    @Query("command") command: String = "request"
  ): SessionTokenResponse
}