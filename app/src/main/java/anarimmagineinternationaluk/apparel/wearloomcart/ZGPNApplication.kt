package anarimmagineinternationaluk.apparel.wearloomcart

import android.app.Application
import anarimmagineinternationaluk.apparel.wearloomcart.di.dataModule
import anarimmagineinternationaluk.apparel.wearloomcart.di.dispatcherModule
import anarimmagineinternationaluk.apparel.wearloomcart.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ZGPNApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@ZGPNApplication)
            modules(appModules)
        }
    }
}
