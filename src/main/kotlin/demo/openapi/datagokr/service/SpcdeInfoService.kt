package demo.openapi.datagokr.service

import okhttp3.OkHttpClient
import org.springframework.stereotype.Component
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import demo.openapi.datagokr.model.SpcdeInfoItem
import demo.openapi.datagokr.model.SpcdeInfoResponse

@Component
class SpcdeInfoService() {

    private val serviceKey = "FdZXQ75RUUh/0rwuqiKT7Xc+ghxyaURhnpa8C9S4Q5LU25dHwM+RmiTCZhaIT0xQeqLC+3QrhdGDBNKv6lr9eg=="
    private val domain = "http://apis.data.go.kr"

    fun getHoliDeInfo(year: Int, month: Int): MutableList<SpcdeInfoItem> {
        val solMonth = month.toString().padStart(2, '0')
        val retrofit = Retrofit.Builder().baseUrl(domain).client(OkHttpClient.Builder().build())
            .addConverterFactory(JaxbConverterFactory.create()).build()
        val service = retrofit.create(SpcdeInfoApi::class.java)
        val call: Call<SpcdeInfoResponse> = service.getHoliDeInfo(serviceKey, 1, 20, year, solMonth)
        val response = call.execute().body()

        if (response?.body?.items?.item == null) {
            return mutableListOf()
        }


//        call.enqueue(object : Callback<SpcdeInfoResponse> {
//            override fun onResponse(call: Call<SpcdeInfoResponse>, response: Response<SpcdeInfoResponse>) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<SpcdeInfoResponse>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })


        return response.body.items.item!!
    }


}