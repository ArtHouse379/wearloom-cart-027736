package anarimmagineinternationaluk.apparel.wearloomcart.ui.state

data class CartItemUiState(
    val productId: Int,
    val productTitle: String,
    val productPrice: Double,
    val quantity: Int,
    val productImageUrl: String,
)
