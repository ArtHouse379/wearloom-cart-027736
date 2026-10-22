package anarimmagineinternationaluk.apparel.wearloomcart.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import anarimmagineinternationaluk.apparel.wearloomcart.data.entity.OrderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Query("SELECT * FROM orders")
    fun observeAll(): Flow<List<OrderEntity>>

    @Insert
    suspend fun save(orderEntity: OrderEntity): Long
}
