package com.example.yemeksepeti.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.yemeksepeti.retrofit.ApiUtils
import com.example.yemeksepeti.entity.Yemekler
import com.example.yemeksepeti.entity.YemeklerCevap
import com.example.yemeksepeti.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {

    private val yemeklerListesi: MutableLiveData<List<Yemekler>>
    private val yemeklerdaoInterface: YemeklerDaoInterface

    init {
        yemeklerdaoInterface = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl() {
        yemeklerdaoInterface.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }
            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {}
        })
    }

}



