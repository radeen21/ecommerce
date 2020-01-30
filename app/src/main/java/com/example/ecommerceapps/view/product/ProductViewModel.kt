package com.example.ecommerceapps.view.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapps.data.model.ProductPromo
import com.example.ecommerceapps.data.repository.EcommerceRepository
import com.example.ecommerceapps.util.Coroutines
import kotlinx.coroutines.Job

class ProductViewModel(private val repository: EcommerceRepository) : ViewModel() {

    private lateinit var job: Job

    init {
        job = Coroutines.ioThenMain(
            { repository.getEcommerces() },
            {
                it?.firstOrNull()?.data?.productPromo?.let {
                    _productPromo.value = it
                }
            }
        )
    }

    private val _product = MutableLiveData<ProductPromo>()
    val products: LiveData<ProductPromo> = _product

    private val _productPromo = MutableLiveData<List<ProductPromo>>()
    val productPromos: LiveData<List<ProductPromo>>
        get() = _productPromo

    fun loadProduct(productPromo: ProductPromo) {
        _product.value = productPromo
    }

    override fun onCleared() {
        if (::job.isInitialized) job.cancel()
        super.onCleared()
    }
}