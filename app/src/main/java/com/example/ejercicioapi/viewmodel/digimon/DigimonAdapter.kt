package com.example.ejercicioapi.viewmodel.digimon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.R
import com.example.ejercicioapi.model.digimon.Digimon

class DigimonAdapter(private val list: List<Digimon>): RecyclerView.Adapter<DigimonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DigimonViewHolder(layoutInflater.inflate(R.layout.item_digimon, parent, false))
    }

    override fun onBindViewHolder(holder: DigimonViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}