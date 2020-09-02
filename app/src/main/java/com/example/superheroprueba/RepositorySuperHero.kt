package com.example.superheroprueba

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.superheroprueba.Retrofit.ApiSuperHero
import com.example.superheroprueba.Retrofit.RetrofitClient
import com.example.superheroprueba.database.RoomDataBaseSuperHero
import com.example.superheroprueba.pojo.SuperHero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response

class RepositorySuperHero(context: Context) {

    private val dataBase: RoomDataBaseSuperHero = RoomDataBaseSuperHero.getDatabase(context)
    private val superHeroList = dataBase.getSuperHeroDao().getAllSuperHeroesList()
    private val tag = "SuperHero Repository"

    fun getListFromRepository(): LiveData<List<SuperHero>> {
        return superHeroList
    }

    //  fun passLiveDataToViewModel() : LiveData<List<SuperHero>> {
    //  return SuperHeroList }

    //Lamada retrofit

    fun fetchDataFromServer() {
        val service: ApiSuperHero = RetrofitClient.retrofitInstance()
        val call: retrofit2.Call<List<SuperHero>> = service.getAllSuperHero()

        call.enqueue(object : Callback<List<SuperHero>> {
            override fun onResponse(
                call: retrofit2.Call<List<SuperHero>>,
                response: Response<List<SuperHero>>
            ) {
                CoroutineScope(Dispatchers.IO).launch {
                    response.body()?.let {
                        dataBase.getSuperHeroDao()
                            .insertAllSuperHero(it)
                    }
                }

            }

            override fun onFailure(call: retrofit2.Call<List<SuperHero>>, t: Throwable) {

                Log.d(tag, t.message.toString())
            }

        })


    }

}
