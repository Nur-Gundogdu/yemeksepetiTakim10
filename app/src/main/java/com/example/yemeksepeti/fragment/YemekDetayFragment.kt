package com.example.yemeksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.yemeksepeti.R
import com.example.yemeksepeti.fragment.YemekDetayFragmentArgs
import com.example.yemeksepeti.databinding.FragmentYemekDetayBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_yemek_detay.*


class YemekDetayFragment : Fragment() {

    private lateinit var tasarim:FragmentYemekDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemek_detay, container, false)

        val b: YemekDetayFragmentArgs by navArgs()
        val gelenYemek = b.yemekNesne

        tasarim.yemekNesnesi=gelenYemek

        var image_name = b.yemekNesne.yemek_resim_adi
        var url ="http://kasimadalan.pe.hu/yemekler/resimler/"+image_name
        var id = tasarim.imageViewYemekResim
        Picasso.get().load(url).into(id)



        //tasarim.imageViewYemekResim.setImageResource(
          //resources.getIdentifier(gelenYemek.yemek_resim_adi,url,requireContext().packageName))

        //Picasso.get().load(url).into(imageViewYemekResim)


        return tasarim.root
    }
}