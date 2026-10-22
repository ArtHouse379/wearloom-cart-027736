package anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import anarimmagineinternationaluk.apparel.wearloomcart.R
import anarimmagineinternationaluk.apparel.wearloomcart.ui.theme.LocalDimens
import kotlinx.coroutines.launch

private const val LOGO_ANIMATION_DURATION_MS = 1600
private const val TITLE_ANIMATION_DURATION_MS = 900

private val LogoSize = 160.dp
private val TitleRise = 12.dp

@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    onAnimationFinished: () -> Unit,
) {
    val dimens = LocalDimens.current

    val scale = remember { Animatable(0.6f) }
    val logoAlpha = remember { Animatable(0f) }
    val titleAlpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            logoAlpha.animateTo(1f, animationSpec = tween(LOGO_ANIMATION_DURATION_MS))
        }
        scale.animateTo(1f, animationSpec = tween(LOGO_ANIMATION_DURATION_MS))
        titleAlpha.animateTo(1f, animationSpec = tween(TITLE_ANIMATION_DURATION_MS))
        onAnimationFinished()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = stringResource(R.string.zgpn_app_logo_description),
                modifier = Modifier
                    .size(LogoSize)
                    .scale(scale.value)
                    .alpha(logoAlpha.value),
            )

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.graphicsLayer {
                    alpha = titleAlpha.value
                    translationY = (1f - titleAlpha.value) * TitleRise.toPx()
                },
            )
        }
    }
}
