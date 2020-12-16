package com.diatrend.manufactapi.service

import com.diatrend.manufactapi.models.*
import retrofit2.Call
import retrofit2.http.*

interface ManufactApiService {
    companion object {
        const val API_ROOT = "api/v1/"
    }
    @GET(API_ROOT + "log_classes/")
    fun getLogClassList() : Call<List<LogClass>>

    @GET(API_ROOT + "base_info_logs/{id}/")
    fun getBaseInfoLog(@Path("id") id : Int): Call<BaseInfoLogDetail>

    @GET(API_ROOT + "base_info_log_list/")
    fun getBaseInfoLogs(@Query("delivery_date_after") deliveryDateAfter: String,
                        @Query("delivery_date_before") deliveryDateBefore: String): Call<List<BaseInfoLog>>

    @POST(API_ROOT + "manufact_logs/")
    fun createManufactLog(@Body manufactLog: ManufactLog): Call<ManufactLog>

    @DELETE(API_ROOT + "manufact_logs/{id}/")
    fun deleteManufactLog(@Path("id") id : Int) : Call<Void>
}