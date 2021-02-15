package com.example.covid_19.model

import com.google.gson.annotations.SerializedName

data class Province(
    @SerializedName("FID")
    val number: Int,
    @SerializedName("Kode Provi")
    val code: Int,
    @SerializedName("Provinsi")
    val nama: String,
    @SerializedName("Kasus_Posi")
    val positif: Int,
    @SerializedName("Kasus_Semb")
    val sembuh: Int,
    @SerializedName("Kasus_Meni")
    val meninggal: Int
)