package com.example.ecommerceapps.data.network

import com.example.ecommerceapps.data.model.EcommerceModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EcommerceApi {

    @GET("home")
    suspend fun getEcommerce() : Response<List<EcommerceModel>>


    companion object{
        operator fun invoke() : EcommerceApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://private-4639ce-ecommerce56.apiary-mock.com/")
                .build()
                .create(EcommerceApi::class.java)
        }
    }

}