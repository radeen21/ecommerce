package com.example.ecommerceapps.data.repository

import com.example.ecommerceapps.data.network.EcommerceApi

class EcommerceRepository (
    private val api: EcommerceApi
) : SafeApiRequest() {

    suspend fun getEcommerces() = apiRequest { api.getEcommerce() }
}