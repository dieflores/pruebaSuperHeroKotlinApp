package com.example.superheroprueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroprueba.pojo.SuperHero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_view_holder.view.*

class AdapterSuperHero(var datasetSuperHero : List<SuperHero>): RecyclerView.Adapter<AdapterSuperHero.ViewHolderSuperHero>() {


    fun updateData(list: List<SuperHero>){
        datasetSuperHero=list
        notifyDataSetChanged()
    }

    class ViewHolderSuperHero(itemView: View): RecyclerView.ViewHolder(itemView){
        var nameSuperHero : TextView = itemView.name_superhero
        var idSuperHero : TextView = itemView.id_superhero
        var imageSuperHero : ImageView = itemView.image_superhero
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSuperHero {
        return ViewHolderSuperHero(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_view_holder,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderSuperHero, position: Int) {
        val hero =datasetSuperHero[position]
        holder.nameSuperHero.text=hero.name
        holder.idSuperHero.text=hero.heroId.toString()

 // esto carga url del pojo hacia la imagen del holder (image view)

        Picasso.get().load(hero.images.md).into(holder.imageSuperHero)
    }

    override fun getItemCount(): Int {
        return datasetSuperHero.size

    }
}