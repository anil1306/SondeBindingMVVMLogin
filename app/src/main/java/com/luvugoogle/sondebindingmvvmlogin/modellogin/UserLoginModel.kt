package com.luvugoogle.sondeloginmvvm.modellogin

import android.util.Patterns


class UserLoginModel() {

    private var userName: String? = null
    private var password: String? = null
    private var fcmToken: String? = null

    constructor(userName: String, password: String, fcmToken: String) : this() {
        this.userName = userName
        this.password = password
        this.fcmToken = fcmToken
    }

    val isEmailValid: Boolean
        get() = Patterns.EMAIL_ADDRESS.matcher(userName).matches()

    val isPasswordLengthGreaterThan5: Boolean
        get() = (password!!.length > 5)

    val isfcmTokenNotNull: Boolean
        get() = (fcmToken!!.length > 1)

}