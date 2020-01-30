package com.example.ecommerceapps.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class EcommerceModel(val data: Data?)

data class Data(
    val category: List<Category>?,
    val productPromo: List<ProductPromo>?
)

@Parcelize
data class Category(
    val imageUrl: String?,
    val id: Int?,
    val name: String?
): Parcelable

@Parcelize
data class ProductPromo(
    val id: String?,
    val imageUrl: String?,
    val title: String?,
    val description: String?,
    val price: String?,
    var loved: Int?
): Parcelable

