package com.example.ecommerceapps.view.category.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapps.data.model.Category
import com.example.ecommerceapps.data.repository.EcommerceRepository
import com.example.ecommerceapps.util.Coroutines
import kotlinx.coroutines.Job

class CategoryDetailViewModel (
    private val repository: EcommerceRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _categoryDetails = MutableLiveData<List<Category>>()
    val categoryDetails: LiveData<List<Category>>
        get() = _categoryDetails

    fun getCategoryDetail() {
        job = Coroutines.ioThenMain(
            { repository.getEcommerces() },
            {
                it?.firstOrNull()?.data?.category?.let {
                    _categoryDetails.value = it
                }
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}