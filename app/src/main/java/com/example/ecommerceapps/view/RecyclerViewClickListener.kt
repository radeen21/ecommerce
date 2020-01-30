package com.example.ecommerceapps.view

import android.view.View
import com.example.ecommerceapps.view.product.ProductViewModel

interface RecyclerViewClickListener {
    fun onRecyclerViewCategoryItemClick(view: View, category: Int)
    fun onRecyclerViewProducttemClick(view: View, product: ProductViewModel)
}