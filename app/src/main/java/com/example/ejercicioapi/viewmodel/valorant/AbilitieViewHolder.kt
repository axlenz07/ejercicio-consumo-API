package com.example.ejercicioapi.viewmodel.valorant

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.databinding.ItemAbilitesBinding
import com.example.ejercicioapi.model.valorant.Abilities
import com.squareup.picasso.Picasso

class AbilitieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemAbilitesBinding.bind(itemView)

    fun bind(temp: Abilities){
        binding.tvNameAbilitie.text = temp.nameAbilitie
        binding.tvDescAbilitie.text = temp.descAbilitie
        Picasso.get().load(temp.iconAbilitie).into(binding.ivIconAbili)
    }
}