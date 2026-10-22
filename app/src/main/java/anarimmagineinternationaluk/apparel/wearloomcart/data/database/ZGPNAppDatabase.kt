package anarimmagineinternationaluk.apparel.wearloomcart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import anarimmagineinternationaluk.apparel.wearloomcart.data.database.dao.CartItemDao
import anarimmagineinternationaluk.apparel.wearloomcart.data.database.dao.OrderDao
import anarimmagineinternationaluk.apparel.wearloomcart.data.database.converter.Converters
import anarimmagineinternationaluk.apparel.wearloomcart.data.entity.CartItemEntity
import anarimmagineinternationaluk.apparel.wearloomcart.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ZGPNAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}