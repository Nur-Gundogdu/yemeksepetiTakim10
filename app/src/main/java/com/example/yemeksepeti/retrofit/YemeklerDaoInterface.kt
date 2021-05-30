package com.example.yemeksepeti.retrofit

import com.example.yemeksepeti.entity.CRUDCevap
import com.example.yemeksepeti.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDaoInterface {

    @GET("yemekler/tum_yemekler.php")
    fun tumYemekler():Call<YemeklerCevap>

    @GET("yemekler/resimler.php")
    fun tumResimler():Call<YemeklerCevap>

    @GET("yemekler/resimler.php/")
    fun tekResimAl(@Field("yemek_resim_adi") yemek_resim_ad:String):Call<YemeklerCevap>

    }