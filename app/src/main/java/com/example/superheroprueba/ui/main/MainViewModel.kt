package com.example.superheroprueba.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.superheroprueba.RepositorySuperHero
import com.example.superheroprueba.pojo.SuperHero

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // lateinit var mRepositorySuperHero: RepositorySuperHero
    private val mRepositorySuperHero = RepositorySuperHero(application)
   // lateinit var

    fun mTraerDatos(){
        mRepositorySuperHero.fetchDataFromServer()
        Log.d("DIEGO", "Estoy en funcion mtraerdatos in class MainViewModel")
    }

    fun getListFromViewModel(): LiveData<List<SuperHero>>{
       return mRepositorySuperHero.getListFromRepository()
    }
}