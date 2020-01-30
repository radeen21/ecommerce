package com.example.ecommerceapps.view.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapps.data.model.Category
import com.example.ecommerceapps.data.repository.EcommerceRepository
import com.example.ecommerceapps.util.Coroutines
import kotlinx.coroutines.Job

class CategoryViewModel(private val repository: EcommerceRepository) : ViewModel() {

    private lateinit var job: Job

    init {
        job = Coroutines.ioThenMain(
            { repository.getEcommerces() },
            {
                it?.firstOrNull()?.data?.category?.let {
                    _categories.value = it
                }
            }
        )
    }

    private val _category = MutableLiveData<Category>()
    val category: LiveData<Category> = _category

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    fun loadCategory(category: Category) {
        _category.value = category
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}