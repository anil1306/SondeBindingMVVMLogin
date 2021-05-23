package com.luvugoogle.sondebindingmvvmlogin.modellogin

import com.google.gson.annotations.SerializedName

data class Email(@SerializedName("isVerified")
                 val isVerified: Boolean = false,
                 @SerializedName("value")
                 val value: String = "")