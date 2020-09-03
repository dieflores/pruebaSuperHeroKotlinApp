package com.example.superheroprueba.pojo

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "superHero_table")
data class SuperHero(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) val heroId: Int,
    val name: String,
    @Embedded val powerstats: PowerStats,
    @Embedded val images: ImageSH
) {
}