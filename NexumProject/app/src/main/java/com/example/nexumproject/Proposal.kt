package com.example.nexumproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.Matches
import com.example.nexumproject.services.shared.controle.acesso.MatchService

class Proposal : AppCompatActivity() {

    private val matchService: MatchService = MatchService();
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterProposta
    private lateinit var btnVoltar: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proposal)
        recyclerView = findViewById(R.id.proposal)
        btnVoltar = findViewById(R.id.btnVoltar)
        adapter = AdapterProposta(this, ArrayList())
        recyclerView.adapter = adapter

        renderList(this)

            voltar()

    }

    fun voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeFreelancer::class.java)
            startActivity(intent)
        }
    }

    fun renderList(context: Context) {

        val prefs = context.getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)
        var idUser = id?.toLongOrNull() ?: 0

        matchService.getMatchsRequestByFreelancerId(idUser);
        Toast.makeText(this, matchService.freelancerByIdList.toString(), Toast.LENGTH_SHORT).show()
        matchService.freelancerByIdList.observe(this) { proposta ->

            if (proposta != null) {

                adapter.setData(proposta)
                adapter.notifyDataSetChanged()
            }
        }
    }
}