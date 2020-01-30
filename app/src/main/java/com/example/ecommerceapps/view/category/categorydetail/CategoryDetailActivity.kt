package com.example.ecommerceapps.view.category.categorydetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceapps.R
import com.example.ecommerceapps.data.model.Category
import kotlinx.android.synthetic.main.category_detail_fragment.*

class CategoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_detail_fragment)

        val category = intent.getParcelableExtra<Category>("data")
//        tvTest?.setText(category.name)
    }
}