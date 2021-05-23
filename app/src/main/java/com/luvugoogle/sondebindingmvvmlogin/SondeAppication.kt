package com.luvugoogle.sondebindingmvvmlogin

import android.app.Application
import android.content.Context

class SondeAppication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: SondeAppication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

    }
}