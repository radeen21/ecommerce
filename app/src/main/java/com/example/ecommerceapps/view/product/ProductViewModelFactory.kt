package com.example.ecommerceapps.view.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapps.data.repository.EcommerceRepository

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory (
    private val repository: EcommerceRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }

}