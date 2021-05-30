package com.example.yemeksepeti.entity

import com.example.yemeksepeti.entity.Yemekler
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YemeklerCevap(
        @SerializedName("yemekler")
    @Expose
    var yemekler:List<Yemekler>,
        @SerializedName("success")
    @Expose
    var success:Int) {
}