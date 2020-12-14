package com.diatrend.manufactapi.models

import java.util.*

data class ManufactLog(
    var id:Int = 0,
    var base_info_log:Int = 0,
    var log_class:Int = 0,
    var created: Date? = null,
    var member:String = ""
)