package com.example.ejercicioapi.viewmodel.digimon

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.databinding.ItemDigimonBinding
import com.example.ejercicioapi.model.digimon.Digimon
import com.squareup.picasso.Picasso

class DigimonViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemDigimonBinding.bind(view)

    fun bind(xd: Digimon) {
        Picasso.get().load(xd.imagen).into(binding.ivDig)
        binding.tvName.text = xd.nombre
        binding.tvLevel.text = xd.nivel
    }
}