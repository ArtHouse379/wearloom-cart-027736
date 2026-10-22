package anarimmagineinternationaluk.apparel.wearloomcart.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.HighQuality
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Filled.HighQuality,
        text = "Quality materials",
    ),
    Benefit(
        icon = Icons.Filled.VerifiedUser,
        text = "Reliable warranty",
    ),
    Benefit(
        icon = Icons.Filled.Checkroom,
        text = "Wardrobe essentials",
    ),
)
