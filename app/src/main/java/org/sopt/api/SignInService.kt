package org.sopt.api

import org.sopt.data.request.RequestSignInData
import org.sopt.data.response.ResponseSignInData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInService {
    @POST("/login/signin")
    fun postSignin(
        @Body body: RequestSignInData
    ): Call<ResponseSignInData>
}