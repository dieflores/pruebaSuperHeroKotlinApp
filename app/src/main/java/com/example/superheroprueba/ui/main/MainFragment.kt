package com.example.superheroprueba.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroprueba.AdapterSuperHero
import com.example.superheroprueba.R
import com.example.superheroprueba.pojo.SuperHero
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    lateinit var mAdapterSuperHero: AdapterSuperHero

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var mViewModel: MainViewModel
    private lateinit var lista: List<SuperHero>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lista = ArrayList()
        mAdapterSuperHero = AdapterSuperHero(lista)

        // mViewModel.getListFromViewModel()
        // sin livedata
        //   val superheroList = mViewModel.getListFromViewModel()
        //  mAdapterSuperHero = AdapterSuperHero(superheroList)

        reciclerViewSuperHero.adapter = mAdapterSuperHero
        reciclerViewSuperHero.layoutManager = LinearLayoutManager(context)
        // con livedata
        mViewModel.getListFromViewModel().observe(viewLifecycleOwner, {
            mAdapterSuperHero.updateData(it)
        })
    }

}