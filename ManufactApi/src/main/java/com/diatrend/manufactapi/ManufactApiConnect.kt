package com.diatrend.manufactapi

import android.annotation.SuppressLint
import com.diatrend.manufactapi.models.*
import com.diatrend.manufactapi.service.ManufactApiRepository
import retrofit2.Response
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class ManufactApiConnect(server: String) {
    @SuppressLint("SimpleDateFormat")
    private val SDF_DATE = SimpleDateFormat("yyyy-MM-dd")
    private val manufactApiRepository = ManufactApiRepository(server)
    var isConnect: Boolean = false

    fun getLogClassList() : List<LogClass>? {
        isConnect = false
        return try {
            val response = manufactApiRepository.getLogClassList()
            if (response.isSuccessful) {
                isConnect = true
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun getBaseInfoLog(id: Int) : BaseInfoLogDetail? {
        isConnect = false
        return  try {
            val response = manufactApiRepository.getBaseInfoLog(id)
            if (response.isSuccessful) {
                isConnect = true
                response.body()
            }
            else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }

    fun getBaseInfoLogList(deliveryDateAfter: Date?, deliveryDateBefore: Date?) : List<BaseInfoLog>? {
        isConnect = false
        return  try {
            val deliveryDateAfterString = if (deliveryDateAfter == null) "" else SDF_DATE.format(deliveryDateAfter)
            val deliveryDateBeforeString = if (deliveryDateBefore == null) "" else SDF_DATE.format(deliveryDateBefore)
            val response = manufactApiRepository.getBaseInfoLogList(deliveryDateAfterString, deliveryDateBeforeString)
            if (response.isSuccessful) {
                isConnect = true
                response.body()
            }
            else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
 }