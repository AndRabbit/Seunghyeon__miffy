package org.sopt.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val signInService: SignInService = retrofit.create(SignInService::class.java)
    val signUpService: SignUpService = retrofit.create(SignUpService::class.java)
}