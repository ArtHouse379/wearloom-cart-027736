package anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.productdetails.header

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import anarimmagineinternationaluk.apparel.wearloomcart.R
import anarimmagineinternationaluk.apparel.wearloomcart.data.model.Product
import anarimmagineinternationaluk.apparel.wearloomcart.ui.theme.LocalDimens

@Composable
fun ProductHeader(
    product: Product,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {
        Text(
            text = product.title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.headlineSmall,
        )

        Spacer(modifier = Modifier.height(dimens.tightSpacing))

        Text(
            text = stringResource(product.category.titleRes),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(modifier = Modifier.height(dimens.contentSpacing))

        Text(
            text = stringResource(R.string.price, product.price),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}
