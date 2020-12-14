package com.diatrend.manufactapi.service

import com.diatrend.manufactapi.models.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class ManufactApiRepository(server : String) {

    private val moshi = Moshi.Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(server)
        .build()

    private val manufactApiService : ManufactApiService = retrofit.create(ManufactApiService::class.java)

    fun getLogClassList() : Response<List<LogClass>> =
        manufactApiService.getLogClassList().execute()

    fun getBaseInfoLog(id: Int) : Response<BaseInfoLogDetail> =
        manufactApiService.getBaseInfoLog(id).execute()

    fun addManufactLog(manufactLog: ManufactLog) : Response<ManufactLog> =
        manufactApiService.createManufactLog(manufactLog).execute()

    fun deleteManufactLog(id: Int) : Response<Void> =
        manufactApiService.deleteManufactLog(id).execute()
}