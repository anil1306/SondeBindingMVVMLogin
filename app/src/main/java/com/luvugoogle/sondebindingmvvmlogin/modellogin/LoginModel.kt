package com.luvugoogle.sondebindingmvvmlogin.modellogin

import com.google.gson.annotations.SerializedName

data class LoginModel(@SerializedName("IdToken")
                      val idToken: String = "",
                      @SerializedName("ExpiresIn")
                      val expiresIn: Int = 0,
                      @SerializedName("TokenType")
                      val tokenType: String = "",
                      @SerializedName("RefreshToken")
                      val refreshToken: String = "",
                      @SerializedName("AccessToken")
                      val accessToken: String = "",
                      @SerializedName("requestId")
                      val requestId: String = "",
                      @SerializedName("me")
                      val me: Me,
                      @SerializedName("appLogCredentials")
                      val appLogCredentials: AppLogCredentials)