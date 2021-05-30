package com.example.yemeksepeti.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksepeti.entity.Yemekler
import com.example.yemeksepeti.repo.YemeklerDaoRepository

class YemeklerAnasayfaFragmentViewModel : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    private val kdaor = YemeklerDaoRepository()



    init {
        yemekleriYukle()
        yemeklerListesi = kdaor.yemekleriGetir()
    }

    fun yemekleriYukle() {
        kdaor.tumYemekleriAl()
    }


}