package com.discount.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coupons")
data class Coupon(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    val platform: String = "",
    val amount: String = "",
    val amountValue: Double = 0.0,
    val threshold: String = "",
    val expireDate: String = "",
    val status: String = "UNUSED",       // UNUSED / USED / EXPIRED
    val imagePath: String = "",
    val note: String = "",
    val createTime: Long = System.currentTimeMillis(),
    val updateTime: Long = System.currentTimeMillis(),
    val usedTime: Long = 0L
)
