package com.luvugoogle.sondebindingmvvmlogin.modellogin

import com.google.gson.annotations.SerializedName

data class Name(@SerializedName("firstName")
                val firstName: String = "")