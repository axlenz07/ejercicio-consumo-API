package com.example.ejercicioapi.viewmodel.valorant

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.databinding.ItemAgentBinding
import com.example.ejercicioapi.model.valorant.Agents
import com.squareup.picasso.Picasso

class ValorantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemAgentBinding.bind(itemView)

    fun bind(temp: Agents){
        binding.tvName.text = temp.nombre
        binding.tvInfo.text = temp.info
        Picasso.get().load(temp.image).into(binding.ivAgent)
    }

}