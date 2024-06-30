package eu.tutorials.myrecipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
):Parcelable

data class CategoriesResponse(val categories: List<Category>)
