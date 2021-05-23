package com.luvugoogle.sondeloginmvvm.remote

import com.luvugoogle.sondebindingmvvmlogin.modellogin.LoginModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApiService {

    @POST("user-management/users/login")
    suspend fun logInPostRequest(@Body body: LoginBody?): LoginModel
}