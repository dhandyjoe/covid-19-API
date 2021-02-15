package com.example.covid_19.api

import com.example.covid_19.model.IndonesiaResponse
import com.example.covid_19.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface Api {

    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvinsi(): Call<ArrayList<ProvinceResponse>>
}