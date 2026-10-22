package anarimmagineinternationaluk.apparel.wearloomcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.approot.AppRoot
import anarimmagineinternationaluk.apparel.wearloomcart.ui.theme.ZGPNAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZGPNAppTheme {
                AppRoot()
            }
        }
    }
}
