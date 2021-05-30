package com.example.yemeksepeti.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksepeti.databinding.YemekCardBinding
import com.example.yemeksepeti.entity.Yemekler
import com.example.yemeksepeti.fragment.YemeklerAnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_yemek_detay.*

class YemeklerAdapter(var mContext:Context, var yemeklerListesi:List<Yemekler>)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(yemekCardBinding: YemekCardBinding):RecyclerView.ViewHolder(yemekCardBinding.root){
        var tasarim:YemekCardBinding

        init {
            this.tasarim = yemekCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = YemekCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        t.yemekNesnesi=yemek
        //holder.tasarim.imageViewYemek.setImageResource(
          //  mContext.resources.getIdentifier(yemek.yemek_resim_adi,"drawable",mContext.packageName))

        var url = "http://kasimadalan.pe.hu/yemekler/resimler/"+yemek.yemek_resim_adi
        var id=holder.tasarim.imageViewYemek
        Picasso.get().load(url).into(id)

        holder.tasarim.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${yemek.yemek_adi} sepete eklendi.",Snackbar.LENGTH_SHORT).show()
        }

        holder.tasarim.yemekCardview.setOnClickListener {
            val gecis = YemeklerAnasayfaFragmentDirections.yemekDetayGecis(yemek)

            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
       return yemeklerListesi.size
    }

}