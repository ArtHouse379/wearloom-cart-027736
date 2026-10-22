package anarimmagineinternationaluk.apparel.wearloomcart.data.repository

import anarimmagineinternationaluk.apparel.wearloomcart.data.model.Product
import anarimmagineinternationaluk.apparel.wearloomcart.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Floral Dress",
            description = "A lightweight floral dress designed for warm days and relaxed occasions. The softly shaped waist creates an easy, flattering silhouette. Pair it with sandals for daytime wear or layer it with a cardigan when the temperature drops.",
            category = ProductCategory.WOMENS_CLOTHING,
            price = 49.95,
            imageUrl = "https://images.unsplash.com/photo-1583914143620-46298183773a",
        ),
        Product(
            id = 2,
            title = "Knit Cardigan",
            description = "This soft knit cardigan adds comfortable warmth without feeling bulky. Its versatile shape works over dresses, shirts, and everyday tops. Wear it open for a relaxed layer or button it up on cooler days.",
            category = ProductCategory.WOMENS_CLOTHING,
            price = 42.00,
            imageUrl = "https://images.unsplash.com/photo-1543204638-6b453005484a",
        ),
        Product(
            id = 3,
            title = "Denim Jacket",
            description = "A classic denim jacket made for dependable everyday layering. The structured cotton denim softens naturally with regular wear. It pairs easily with chinos, T-shirts, and casual weekend outfits.",
            category = ProductCategory.MENS_CLOTHING,
            price = 64.50,
            imageUrl = "https://images.unsplash.com/photo-1646251165758-df8462c08202",
        ),
        Product(
            id = 4,
            title = "Oxford Shirt",
            description = "This cotton Oxford shirt balances a neat collar with a comfortable everyday fit. Its clean white finish suits workdays, dinners, and smarter casual outfits. Wear it tucked with trousers or open over a plain T-shirt.",
            category = ProductCategory.MENS_CLOTHING,
            price = 38.00,
            imageUrl = "https://images.unsplash.com/photo-1603252109612-24fa03d145c8",
        ),
        Product(
            id = 5,
            title = "Canvas Sneakers",
            description = "Low-top canvas sneakers offer a simple finish for everyday outfits. A flexible upper and flat rubber sole keep them comfortable for casual walking. Their neutral colour works well with denim, shorts, and relaxed dresses.",
            category = ProductCategory.FOOTWEAR,
            price = 44.95,
            imageUrl = "https://images.unsplash.com/photo-1422728221357-57980993ea99",
        ),
        Product(
            id = 6,
            title = "Leather Boots",
            description = "These leather boots combine a sturdy sole with a timeless ankle-height profile. The durable upper is suited to frequent wear through cooler months. Style them with jeans, work trousers, or a casual dress.",
            category = ProductCategory.FOOTWEAR,
            price = 89.00,
            imageUrl = "https://images.unsplash.com/photo-1573516037033-bccea591d544",
        ),
        Product(
            id = 7,
            title = "Cotton Fabric Bundle",
            description = "A coordinated bundle of cotton fabric for sewing, patchwork, and home projects. The woven material is easy to cut, press, and stitch for makers of all levels. Use the varied colours for garments, cushions, or reusable accessories.",
            category = ProductCategory.TEXTILES,
            price = 24.50,
            imageUrl = "https://images.unsplash.com/photo-1650324371896-f0b4bc2238dd",
        ),
        Product(
            id = 8,
            title = "Satin Fabric",
            description = "This smooth satin fabric has a soft drape and a subtle glossy finish. It is well suited to occasion wear, linings, scarves, and decorative sewing. Sold by the metre, it can be ordered in the quantity your project requires.",
            category = ProductCategory.TEXTILES,
            price = 12.95,
            imageUrl = "https://images.unsplash.com/photo-1756361771567-e276865b77cb",
        ),
        Product(
            id = 9,
            title = "Leather Belt",
            description = "A simple leather belt that finishes both smart and casual looks. Its adjustable buckle provides a secure fit with jeans or tailored trousers. The solid construction is designed to develop character with regular wear.",
            category = ProductCategory.ACCESSORIES,
            price = 29.95,
            imageUrl = "https://images.unsplash.com/photo-1732257119896-5c16140c4c49",
        ),
        Product(
            id = 10,
            title = "Canvas Tote Bag",
            description = "This reusable canvas tote bag offers practical space for shopping and daily essentials. Strong handles make it comfortable to carry by hand or over the shoulder. Its fabric construction folds flat for easy storage between uses.",
            category = ProductCategory.ACCESSORIES,
            price = 16.00,
            imageUrl = "https://images.unsplash.com/photo-1772890753143-24991d807710",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
