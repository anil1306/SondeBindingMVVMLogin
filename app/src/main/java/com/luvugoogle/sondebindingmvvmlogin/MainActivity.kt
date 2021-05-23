package com.luvugoogle.sondebindingmvvmlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.luvugoogle.sondebindingmvvmlogin.databinding.ActivityMainBinding
import com.luvugoogle.sondebindingmvvmlogin.modellogin.LoginModel
import com.luvugoogle.sondebindingmvvmlogin.ui.ViewModelFactory
import com.luvugoogle.sondebindingmvvmlogin.viewmodel.LoginViewModel
import com.luvugoogle.sondeloginmvvm.remote.LoginApiService
import com.luvugoogle.sondeloginmvvm.remote.RetrofitClient
import com.luvugoogle.sondeloginmvvm.util.Status
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    lateinit var activityMainBinding: ActivityMainBinding
    /*var userName = "ajay21@yopmail.com"
    var password ="Test@1234"
    var fcmToken ="adfssafdskfdajfdlkfjdfjfljdffaff"*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
       // activityMainBinding. = this
        //loginViewModel = ViewModelProviders.of(this).get<LoginViewModel>(LoginViewModel::class.java)

        /*provide login parameters from here  validate from a function*/
        setupViewModel()
        setUpObserver()
    }
    fun addUser() {
        openAddMessageDialog()
    }

    private fun openAddMessageDialog() {
        Toast.makeText(this, "HI", Toast.LENGTH_LONG).show()

    }
    private fun retrieveList(user: ArrayList<LoginModel?>) {
        //if (user.size > 0) {
        Log.e("TAG", "retrieveList: "+user.get(0)?.accessToken )
        //}
    }
    private fun setupViewModel() {
        loginViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(RetrofitClient.apiClient().create(LoginApiService::class.java))
        ).get(LoginViewModel::class.java)
    }
    private fun setUpObserver() {
        loginViewModel?.loginUser()?.observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        showProgress(false)

                        resource.data.let {call ->it}
                        resource.data.let { println("$it!!") }
                        resource.data?.let { retrieveList(it as ArrayList<LoginModel?>) }
                        //resource.data?.let { users -> retrieveList(users as ArrayList<LoginModel?>) }
                      //  Toast.makeText(this, it.data, Toast.LENGTH_LONG).show()
                    }
                    Status.ERROR -> {
                        showProgress(false)
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        showProgress(true)
                    }
                }

            }
        })
    }
   /* private fun doLogin() {
        loginViewModel?.login?.observe(this, object : Observer<List<LoginModel?>?> {
            override fun onChanged(t: List<LoginModel?>?) {
                TODO("Not yet implemented")
            }

        })
    }*/

    private fun showProgress(status: Boolean) {
        if (status) {
            activityMainBinding.showProgress.visibility = View.VISIBLE
        } else {
            activityMainBinding.showProgress.visibility = View.GONE
        }
    }
}