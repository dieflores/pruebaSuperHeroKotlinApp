package com.example.superheroprueba.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [SuperHeroDao::class], version = 1, exportSchema = false)
abstract class RoomDataBaseSuperHero : RoomDatabase() {

    abstract fun getSuperHeroDao(): SuperHeroDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBaseSuperHero? = null

        fun getDatabase(context: Context): RoomDataBaseSuperHero {
            val tempInstance: RoomDataBaseSuperHero? = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance :RoomDataBaseSuperHero = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBaseSuperHero::class.java,
                    "superHero_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}