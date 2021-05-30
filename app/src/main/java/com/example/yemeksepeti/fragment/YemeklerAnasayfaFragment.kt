package com.example.yemeksepeti.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksepeti.R
import com.example.yemeksepeti.entity.Yemekler
import com.example.yemeksepeti.adapter.YemeklerAdapter
import com.example.yemeksepeti.databinding.FragmentYemeklerAnasayfaBinding
import com.example.yemeksepeti.viewmodel.YemeklerAnasayfaFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_yemek_detay.*


class YemeklerAnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var tasarim: FragmentYemeklerAnasayfaBinding
    private lateinit var adapter: YemeklerAdapter
    private lateinit var viewModel: YemeklerAnasayfaFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_yemekler_anasayfa, container, false)

        tasarim.rvyemek.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)



        viewModel.yemeklerListesi.observe(viewLifecycleOwner, Observer{ yemeklerListesi ->
            adapter= YemeklerAdapter(requireContext(),yemeklerListesi)
            tasarim.yemeklerAdapter=adapter
        })
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        //Fragment içinde viewModel tanımlaması
        val tempViewModel: YemeklerAnasayfaFragmentViewModel by viewModels()
        this.viewModel = tempViewModel
    }
    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }


}