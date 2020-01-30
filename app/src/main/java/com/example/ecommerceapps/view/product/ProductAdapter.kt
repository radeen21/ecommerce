package com.example.ecommerceapps.view.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapps.R
import com.example.ecommerceapps.data.model.ProductPromo
import com.example.ecommerceapps.databinding.RecyclerviewProductBinding

class ProductAdapter (private val products: List<ProductPromo>,
                      private val viewModel: ProductViewModel
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_product,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.recyclerviewProductBinding.apply {
            vmProduct = viewModel
            product = products[position]
            ivLike.setOnClickListener {
                if (products[0].loved == 1) {
                    ivLike.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp)
                    products[0].loved = 0
                } else {
                    ivLike.setBackgroundResource(R.drawable.ic_favorite_black_24dp)
                    products[0].loved = 1
                }
            }
        }
    }

    inner class ProductViewHolder(
        val recyclerviewProductBinding: RecyclerviewProductBinding
    ) : RecyclerView.ViewHolder(recyclerviewProductBinding.root)

}