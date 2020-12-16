package com.diatrend.manufactapi

import org.junit.Test

import org.junit.Assert.*
import java.util.*

class ManufactApiConnectTest {

    @Test
    fun getBaseInfoLogList() {
        val manufactApiConnect = ManufactApiConnect("http://192.168.100.162:8000/")
        val baseInfoLogList = manufactApiConnect.getBaseInfoLogList(Date(), null)
        baseInfoLogList?.sortedWith(compareBy({it.delivery_date}, {it.order_number}))?.forEach {
            println(it.order_number)
        }
    }
}