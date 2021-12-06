package demo.openapi.datagokr.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import demo.openapi.datagokr.model.SpcdeInfoResponse

interface SpcdeInfoApi {

    @GET("B090041/openapi/service/SpcdeInfoService/getHoliDeInfo")
    fun getHoliDeInfo(
        @Query("ServiceKey") serviceKey: String,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("solYear") solYear: Int,
        @Query("solMonth") solMonth: String
    ): Call<SpcdeInfoResponse>

}