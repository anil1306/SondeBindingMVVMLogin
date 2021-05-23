package com.luvugoogle.sondeloginmvvm.modellogin

import androidx.lifecycle.MutableLiveData
import com.luvugoogle.sondebindingmvvmlogin.modellogin.LoginModel
import okhttp3.ResponseBody
import java.util.*

class LoginRepository {
    var userName = "ajay21@yopmail.com"
    var password = "Test@1234"
    var fcmToken = "adfssafdskfdajfdlkfjdfjfljdffaff"

    private var loginResponse = ArrayList<ResponseBody>()
    private val mutableLiveData = MutableLiveData<ArrayList<LoginModel>>()

   /* fun getMutableLiveData(): MutableLiveData<ArrayList<LoginModel>> {
        val userDataService: EmployeeDataService = RetrofitClient.service
        val call: Call<LoginModel?>? = userDataService.logInPostRequest(LoginBody(userName, password, fcmToken))
        if (call != null) {
            call.enqueue(object : Callback<LoginModel?> {
                override fun onResponse(
                    call: Call<LoginModel?>,
                    response: Response<LoginModel?>
                ) {
                    val responseBody: LoginModel? = response.body()
                    if (responseBody != null) {
                        //TODO
                        Log.d("TAG","onResponse: " + responseBody.accessToken)
                    }
                }

                override fun onFailure(
                    call: Call<LoginModel?>,
                    t: Throwable
                ) {
                }
            })
        }
        return mutableLiveData
    }*/

   /* fun getMutableLiveData()= liveData(Dispatchers.IO) {
        val userDataService: EmployeeDataService = RetrofitClient.service
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data=userDataService.logInPostRequest(LoginBody(userName, password, fcmToken))))
        }catch (exception: Exception){
            emit(Resource.error(data=null,message = exception.message?:"Error occured"))
        }
    }*/

    companion object {
        private const val TAG = "LoginRepository"
    }
}