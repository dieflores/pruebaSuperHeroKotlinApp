package com.example.superheroprueba.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroprueba.pojo.SuperHero

@Dao
interface SuperHeroDao {

    // Para insertar listado de Super heroes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperHero(listSuperhero: List<SuperHero>)

    //Insertar un solo heroe
    @Insert
    suspend fun insertHero(hero: SuperHero)

    //Traer los elementos de la tabla
    @Query("SELECT * FROM superHero_table ORDER BY heroId DESC")
    fun getAllSuperHeroesList(): LiveData<List<SuperHero>>


}