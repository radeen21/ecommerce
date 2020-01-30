package com.example.ecommerceapps.view.product.productdetail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ecommerceapps.R
import com.example.ecommerceapps.data.model.ProductPromo
import kotlinx.android.synthetic.main.product_detail_activity.*

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail_activity)

        val promo = intent.getParcelableExtra<ProductPromo>("data")
        tvTitleProductDetail?.setText(promo.title)
        tvProductDetail?.setText(promo.description)
        tvPrice?.setText(promo.price)
        Glide.with(this)
            .load(promo.imageUrl)
            .into(ivProductDetail)

        ivShare.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            startActivity(Intent.createChooser(shareIntent,getString(R.string.app_name)))
        }
    }
}