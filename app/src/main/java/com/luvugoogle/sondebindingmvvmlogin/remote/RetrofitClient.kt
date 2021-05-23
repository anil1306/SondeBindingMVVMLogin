package com.luvugoogle.sondeloginmvvm.remote

import android.content.Context
import androidx.databinding.library.BuildConfig
import com.google.gson.GsonBuilder
import com.luvugoogle.sondebindingmvvmlogin.SondeAppication
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://d2u1wndd7r3e2j.cloudfront.net/"
    /*val service: EmployeeDataService
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(buildOkHttpClient(SondeAppication.applicationContext()))
                    .build()
            }
            return retrofit!!.create(EmployeeDataService::class.java)
        }*/
    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun apiClient(): Retrofit{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildOkHttpClient(SondeAppication.applicationContext()))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit

    }
    val certificatePinner = CertificatePinner.Builder()
        .add(
            "www.example.com",
            "sha256/ZC3lTYTDBJQVf1P2V7+fibTqbIsWNR/X7CWNVW+CEEA="
        ).build()

    private fun buildOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .addInterceptor(buildLoggingInterceptor())
            .certificatePinner(certificatePinner)
            .build()
    }

    private fun buildLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }
}