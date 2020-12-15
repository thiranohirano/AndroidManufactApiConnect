package com.diatrend.manufactapi

import com.diatrend.manufactapi.models.*
import com.diatrend.manufactapi.service.ManufactApiRepository
import retrofit2.Response
import java.lang.Exception

class ManufactApiConnect(server: String) {
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
 }