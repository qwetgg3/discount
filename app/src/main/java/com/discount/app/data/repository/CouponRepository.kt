package com.discount.app.data.repository

import com.discount.app.data.local.AppDatabase
import com.discount.app.data.local.Coupon
import kotlinx.coroutines.flow.Flow

class CouponRepository(private val database: AppDatabase) {

    private val couponDao = database.couponDao()

    fun getCouponsByStatus(status: String): Flow<List<Coupon>> {
        return couponDao.getCouponsByStatus(status)
    }

    fun getTotalUsedAmount(): Flow<Double?> {
        return couponDao.getTotalUsedAmount()
    }

    suspend fun getCouponById(id: Long): Coupon? {
        return couponDao.getCouponById(id)
    }

    suspend fun insertCoupon(coupon: Coupon): Long {
        return couponDao.insert(coupon)
    }

    suspend fun updateCoupon(coupon: Coupon) {
        couponDao.update(coupon)
    }

    suspend fun deleteCoupon(coupon: Coupon) {
        couponDao.delete(coupon)
    }

    suspend fun deleteCouponById(id: Long) {
        couponDao.deleteById(id)
    }
}
