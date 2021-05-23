package com.luvugoogle.sondeloginmvvm.remote


class LoginBody() {
    private var userName: String? = null
    private var password: String? = null
    private var fcmToken: String? = null

    constructor(userName: String, password: String, fcmToken: String) : this() {
        this.userName = userName
        this.password = password
        this.fcmToken = fcmToken
    }
}
