package com.luvugoogle.sondebindingmvvmlogin.data.local

interface SharedPreferenceHelper {

    fun clearPrefs()

    fun setIdToken(idToken: String)
    fun getIdToken(): String
}