package com.discount.app.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CouponDao {
    
    @Query("SELECT * FROM coupons WHERE status = :status ORDER BY createTime DESC")
    fun getCouponsByStatus(status: String): Flow<List<Coupon>>
    
    @Query("SELECT * FROM coupons WHERE id = :id")
    suspend fun getCouponById(id: Long): Coupon?
    
    @Query("SELECT SUM(amountValue) FROM coupons WHERE status = 'USED'")
    fun getTotalUsedAmount(): Flow<Double?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coupon: Coupon): Long
    
    @Update
    suspend fun update(coupon: Coupon)
    
    @Delete
    suspend fun delete(coupon: Coupon)
    
    @Query("DELETE FROM coupons WHERE id = :id")
    suspend fun deleteById(id: Long)
}
