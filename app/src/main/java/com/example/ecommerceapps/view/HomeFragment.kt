package com.example.ecommerceapps.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapps.R
import com.example.ecommerceapps.data.model.Category
import com.example.ecommerceapps.data.model.ProductPromo
import com.example.ecommerceapps.data.network.EcommerceApi
import com.example.ecommerceapps.data.repository.EcommerceRepository
import com.example.ecommerceapps.view.category.CategoryAdapter
import com.example.ecommerceapps.view.category.categorydetail.CategoryDetailActivity
import com.example.ecommerceapps.view.category.CategoryViewModel
import com.example.ecommerceapps.view.category.CategoryViewModelFactory
import com.example.ecommerceapps.view.product.ProductAdapter
import com.example.ecommerceapps.view.product.productdetail.ProductDetailActivity
import com.example.ecommerceapps.view.product.ProductViewModel
import com.example.ecommerceapps.view.product.ProductViewModelFactory
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    private val repository: EcommerceRepository by lazy {
        EcommerceRepository(EcommerceApi())
    }

    private val productViewModel: ProductViewModel by lazy {
        val productFactory = ProductViewModelFactory(repository)
        ViewModelProviders.of(this@HomeFragment, productFactory).get(ProductViewModel::class.java)
    }

    private val categoryViewModel: CategoryViewModel by lazy {
        val factory = CategoryViewModelFactory(repository)
        ViewModelProviders.of(this@HomeFragment, factory).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        categoryViewModel.also { vm ->
            vm.category.observe(viewLifecycleOwner, Observer { category -> opencategory(category) })
            vm.categories.observe(viewLifecycleOwner, Observer { categories ->
                recCategories.apply {
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
                    setHasFixedSize(true)
                    adapter = CategoryAdapter(categories, vm)
                }
            })
        }

        productViewModel.also { vmProduct ->
            vmProduct.products.observe(viewLifecycleOwner, Observer { product -> openPromoDetail(product)})
            vmProduct.productPromos.observe(viewLifecycleOwner, Observer { products ->
                recProduct.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    setHasFixedSize(true)
                    adapter = ProductAdapter(products, vmProduct)
                }
            })
        }



    }

    private fun opencategory(category: Category) {
        activity?.let {
            Intent(it, CategoryDetailActivity::class.java).apply {
                putExtra("data", category)
            }.also { intent ->
                it.startActivity(intent)
            }
        }
    }

    private fun openPromoDetail(productPromo: ProductPromo) {
        activity?.let {
            Intent(it, ProductDetailActivity::class.java).apply {
                putExtra("data", productPromo)
            }.also {intent ->
                it.startActivity(intent)
            }
        }
    }
}