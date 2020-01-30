package com.example.ecommerceapps.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapps.R
import com.example.ecommerceapps.data.model.Category
import com.example.ecommerceapps.databinding.RecyclerviewCategoriesBinding

class CategoryAdapter(private val categories: List<Category>,
                      private val viewModel: CategoryViewModel
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_categories,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.recyclerviewCategoriesBinding.apply {
            vm = viewModel
            category = categories[position]
        }
    }

    inner class CategoryViewHolder(
        val recyclerviewCategoriesBinding: RecyclerviewCategoriesBinding
    ) : RecyclerView.ViewHolder(recyclerviewCategoriesBinding.root)
}