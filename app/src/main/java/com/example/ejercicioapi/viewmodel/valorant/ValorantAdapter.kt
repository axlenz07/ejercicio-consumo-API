package com.example.ejercicioapi.viewmodel.valorant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioapi.R
import com.example.ejercicioapi.databinding.ItemAgentBinding
import com.example.ejercicioapi.model.valorant.Agents

class ValorantAdapter(private val list: List<Agents>, private val onAgentClickListener: OnAgentClickListener):
    RecyclerView.Adapter<ValorantViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValorantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ValorantViewHolder(layoutInflater.inflate(R.layout.item_agent, parent, false))
    }

    override fun onBindViewHolder(holder: ValorantViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onAgentClickListener.onAgentItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}