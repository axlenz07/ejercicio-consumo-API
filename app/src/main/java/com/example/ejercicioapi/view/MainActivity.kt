package com.example.ejercicioapi.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicioapi.viewmodel.digimon.DigimonAdapter
import com.example.ejercicioapi.model.digimon.DigimonApi
import com.example.ejercicioapi.databinding.ActivityMainBinding
import com.example.ejercicioapi.model.digimon.Digimon
import com.example.ejercicioapi.model.valorant.Agents
import com.example.ejercicioapi.model.valorant.Valorant
import com.example.ejercicioapi.model.valorant.ValorantApi
import com.example.ejercicioapi.viewmodel.valorant.OnAgentClickListener
import com.example.ejercicioapi.viewmodel.valorant.ValorantAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), OnAgentClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var digAdapter: DigimonAdapter
    private lateinit var agenAdapter: ValorantAdapter
    private val digInfo = mutableListOf<Digimon>()
    private val agentInfo = mutableListOf<Agents>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        binding.btnDigimons.setOnClickListener {
            getAllDigimon()
            binding.rvAgents.visibility = View.INVISIBLE
            binding.rvDigimons.visibility = View.VISIBLE
        }
        binding.btnAgent.setOnClickListener {
            getAllAgents()
            binding.rvAgents.visibility = View.VISIBLE
            binding.rvDigimons.visibility = View.INVISIBLE
        }
    }

    private fun initRecyclerView() {
        digAdapter = DigimonAdapter(digInfo)
        binding.rvDigimons.layoutManager = LinearLayoutManager(this)
        binding.rvDigimons.adapter = digAdapter

        agenAdapter = ValorantAdapter(agentInfo, this)
        binding.rvAgents.layoutManager = LinearLayoutManager(this)
        binding.rvAgents.adapter = agenAdapter

        binding.rvDigimons.visibility = View.INVISIBLE
        binding.rvAgents.visibility = View.INVISIBLE
    }

    private fun getRetrofitDig(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://digimon-api.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllDigimon() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<List<Digimon>> = getRetrofitDig().create(DigimonApi::class.java)
                .getAllDigimon()
            val digimons = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val digimon = digimons ?: emptyList()
                    digInfo.clear()
                    digInfo.addAll(digimon)
                    digAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun getRetrofitVal(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllAgents() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<Valorant> = getRetrofitVal().create(ValorantApi::class.java)
                .getAllAgents()
            val agents = call.body()
            runOnUiThread {
                if (call.isSuccessful){
                    val agent = agents?.datos ?: emptyList()
                    agentInfo.clear()
                    agentInfo.addAll(agent)
                    agenAdapter.notifyDataSetChanged()
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onAgentItemClicked(position: Int) {
        val i = Intent(this, AbilitiesAgent::class.java)
        i.putExtra("agente", agentInfo[position])
        startActivity(i)
    }
}