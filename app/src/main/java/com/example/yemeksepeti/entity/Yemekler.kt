package com.example.yemeksepeti.entity

import java.io.Serializable

data class Yemekler(var yemek_id:Int
                     ,var yemek_adi:String
                     ,var yemek_resim_adi:String
                     ,var yemek_fiyat:Double):Serializable {
}