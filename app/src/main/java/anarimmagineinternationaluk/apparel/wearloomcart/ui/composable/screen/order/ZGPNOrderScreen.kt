package anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.order

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import anarimmagineinternationaluk.apparel.wearloomcart.R
import anarimmagineinternationaluk.apparel.wearloomcart.data.entity.OrderEntity
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.approot.LocalContentBottomPadding
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.order.card.OrderItem
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.shared.DataBasedContainer
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.shared.DataEmptyContent
import anarimmagineinternationaluk.apparel.wearloomcart.ui.state.DataUiState
import anarimmagineinternationaluk.apparel.wearloomcart.ui.theme.LocalDimens
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ZGPNOrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {

        DataBasedContainer(
            modifier = Modifier.fillMaxSize(),
            dataState = ordersState,

            dataPopulated = {
                val data = (ordersState as DataUiState.Populated<List<OrderEntity>>).data

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        start = dimens.screenPadding,
                        end = dimens.screenPadding,
                        top = dimens.screenPadding,
                        bottom = dimens.screenPadding + LocalContentBottomPadding.current,
                    ),
                    verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
                ) {
                    items(items = data, key = { order -> order.orderNumber }) { order ->
                        OrderItem(order = order)
                    }
                }
            },

            dataEmpty = {
                DataEmptyContent(
                    primaryText = stringResource(R.string.orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}
