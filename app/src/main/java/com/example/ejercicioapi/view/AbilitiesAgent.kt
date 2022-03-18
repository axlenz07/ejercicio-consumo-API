package com.example.ejercicioapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioapi.R
import com.example.ejercicioapi.databinding.ActivityAbilitiesAgentBinding
import com.example.ejercicioapi.model.valorant.Abilities
import com.example.ejercicioapi.model.valorant.Agents
import com.example.ejercicioapi.viewmodel.valorant.AbilitieAdapter
import com.squareup.picasso.Picasso

class AbilitiesAgent : AppCompatActivity() {

    private lateinit var binding: ActivityAbilitiesAgentBinding
    private lateinit var abilitieAdapter: AbilitieAdapter
    private val abilities = mutableListOf<Abilities>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbilitiesAgentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val agente = intent.getSerializableExtra("agente") as Agents

        Picasso.get().load(agente.full).into(binding.ivAgent)
        Picasso.get().load(agente.fondo).into(binding.ivBack)

        binding.tvRole.text = agente.rol.rolTexto
        binding.tvRoleDesc.text = agente.rol.rolDesc
        Picasso.get().load(agente.rol.rolIcon).into(binding.ivRole)

        abilitieAdapter = AbilitieAdapter(abilities)
        binding.rvAbilities.layoutManager = LinearLayoutManager(this)
        binding.rvAbilities.adapter = abilitieAdapter

        abilities.clear()
        abilities.addAll(agente.abilities)
        abilitieAdapter.notifyDataSetChanged()

        Log.d("demo", abilities.toString())
    }
}