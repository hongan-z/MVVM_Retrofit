package Retrofit

import ApiService.ApiInterface
import extra.Utils.BASE_URL
import extra.Utils.TODOS_URL
import extra.Utils.ZEN_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    // initialize by lazy
    val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }


    //
    val retrofit2 by lazy {
        Retrofit.Builder().baseUrl(TODOS_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiInterface2 by lazy {
        retrofit2.create(ApiInterface::class.java)
    }

    //
   val retrofitZen by lazy {

       Retrofit.Builder().baseUrl(ZEN_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiInterfaceZen by lazy{
        retrofitZen.create(ApiInterface::class.java)
    }

}