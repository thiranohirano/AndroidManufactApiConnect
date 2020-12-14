package com.diatrend.manufactapi.models

import java.util.*

open class BaseInfoLog {
    var id: Int = 0
    var order_number: String = ""
    var order_date: Date? = null
    var delivery_date: Date? = null
    var customer: String? = null
    var model: String? = null
    var quantity: Int? = 0
}

open class BaseInfoLogDetail: BaseInfoLog() {
    var manufact_logs: List<ManufactLog> = listOf()
}