package com.example.ecommerceapps.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapps.data.repository.EcommerceRepository

@Suppress("UNCHECKED_CAST")
class CategoryViewModelFactory (
    private val repository: EcommerceRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryViewModel(repository) as T
    }

}