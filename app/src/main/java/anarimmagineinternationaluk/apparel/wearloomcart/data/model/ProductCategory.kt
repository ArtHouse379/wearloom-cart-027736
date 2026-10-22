package anarimmagineinternationaluk.apparel.wearloomcart.data.model

import androidx.annotation.StringRes
import anarimmagineinternationaluk.apparel.wearloomcart.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    WOMENS_CLOTHING(R.string.product_category_womens_clothing_title),
    MENS_CLOTHING(R.string.product_category_mens_clothing_title),
    FOOTWEAR(R.string.product_category_footwear_title),
    TEXTILES(R.string.product_category_textiles_title),
    ACCESSORIES(R.string.product_category_accessories_title),
}
