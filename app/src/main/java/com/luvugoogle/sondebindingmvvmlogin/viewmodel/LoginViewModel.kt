package com.luvugoogle.sondebindingmvvmlogin.viewmodel

import androidx.lifecycle.*
import com.luvugoogle.sondeloginmvvm.remote.LoginApiService
import com.luvugoogle.sondeloginmvvm.remote.LoginBody
import com.luvugoogle.sondeloginmvvm.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel(private val apiService: LoginApiService) : ViewModel() {


    var emailAddress = "ajay21@yopmail.com"
    var password = "Test@1234"
    var fcmToken = "adfssafdskfdajfdlkfjdfjfljdffaff"

   /* val emailAddress: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()*/

/*
    private val login: MutableLiveData<UserLoginModel>? = null
    private val loginRepository: LoginRepository
        get()= loginRepository.getMutableLiveData()

    init {
        loginRepository = LoginRepository()
    }


*/


    /* private val loginRepository: LoginRepository
       val login: LiveData<Resource<Call<LoginModel?>?>>
        get()= loginRepository.getMutableLiveData()

    init {
        loginRepository = LoginRepository()
    }*/
///https://stackoverflow.com/questions/60678290/using-livedata-coroutine-builder-on-dispatchers-io-thread

    //fun onClick() {

        fun loginUser() = liveData(Dispatchers.IO) {
            emit(Resource.loading(data = null))
            try {
                emit(
                    Resource.success(
                        data = apiService.logInPostRequest(
                            LoginBody(
                                emailAddress/*.value.toString().trim()*/,
                                password./*value.*/toString().trim(), fcmToken
                            )
                        )
                    )
                )
            } catch (exception: Exception) {
                emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
            }
        }
    //}
}