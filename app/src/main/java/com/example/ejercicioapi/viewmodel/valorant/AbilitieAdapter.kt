package com.example.ejercicioapi.viewmodel.valorant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.R
import com.example.ejercicioapi.model.valorant.Abilities

class AbilitieAdapter(private val list: List<Abilities>): RecyclerView.Adapter<AbilitieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AbilitieViewHolder(layoutInflater.inflate(R.layout.item_abilites, parent, false))
    }

    override fun onBindViewHolder(holder: AbilitieViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}