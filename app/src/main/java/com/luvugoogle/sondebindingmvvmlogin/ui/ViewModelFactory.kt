package com.luvugoogle.sondebindingmvvmlogin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luvugoogle.sondebindingmvvmlogin.viewmodel.LoginViewModel
import com.luvugoogle.sondeloginmvvm.remote.LoginApiService
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiService: LoginApiService) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(apiService)as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}