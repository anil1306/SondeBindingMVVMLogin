package com.luvugoogle.sondebindingmvvmlogin.modellogin

import com.google.gson.annotations.SerializedName

data class AppLogCredentials(@SerializedName("accessKeyId")
                             val accessKeyId: String = "",
                             @SerializedName("secretKey")
                             val secretKey: String = "",
                             @SerializedName("sessionToken")
                             val sessionToken: String = "",
                             @SerializedName("region")
                             val region: String = "")