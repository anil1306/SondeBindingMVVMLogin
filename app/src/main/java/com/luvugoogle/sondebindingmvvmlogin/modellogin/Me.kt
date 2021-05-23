package com.luvugoogle.sondebindingmvvmlogin.modellogin

import com.google.gson.annotations.SerializedName

data class Me(@SerializedName("phoneNumber")
              val phoneNumber: PhoneNumber,
              @SerializedName("gender")
              val gender: String = "",
              @SerializedName("userIdentifier")
              val userIdentifier: String = "",
              @SerializedName("name")
              val name: Name,
              @SerializedName("language")
              val language: String = "",
              @SerializedName("device")
              val device: Device,
              @SerializedName("email")
              val email: Email,
              @SerializedName("yearOfBirth")
              val yearOfBirth: Int = 0)