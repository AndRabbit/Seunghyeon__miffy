package org.sopt.api

import org.sopt.data.request.RequestSignUpData
import org.sopt.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("/login/signup")
    fun postSignup(
        @Body body: RequestSignUpData
    ): Call<ResponseSignUpData>
}