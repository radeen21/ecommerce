package com.example.ecommerceapps.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapps.data.repository.EcommerceRepository
import com.example.ecommerceapps.view.category.categorydetail.CategoryDetailViewModel

class CategotyDetailViewModelFactory (
    private val repository: EcommerceRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryDetailViewModel(
            repository
        ) as T
    }

}