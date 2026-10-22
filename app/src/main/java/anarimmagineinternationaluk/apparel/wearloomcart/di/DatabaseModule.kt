package anarimmagineinternationaluk.apparel.wearloomcart.di

import androidx.room.Room
import anarimmagineinternationaluk.apparel.wearloomcart.data.database.ZGPNAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "zgpn_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = ZGPNAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<ZGPNAppDatabase>().cartItemDao() }

    single { get<ZGPNAppDatabase>().orderDao() }
}