package com.example.nexumproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import com.example.nexumproject.services.shared.controle.acesso.UsersService

class FreelancerProfileList : AppCompatActivity() {

    private val freelancersService: UsersService = UsersService();
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var btnVoltar: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freelancer_profile_list)
        recyclerView = findViewById(R.id.list_recyclerView)
        adapter = Adapter(this, ArrayList())
        recyclerView.adapter = adapter
        btnVoltar = findViewById(R.id.btnVoltar)


        voltar()
        renderList()
    }

    fun voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeContratante::class.java)
            startActivity(intent)
        }

    }
    fun renderList() {
        freelancersService.freelancersList();

        Toast.makeText(this, freelancersService.usersList.toString(), Toast.LENGTH_SHORT).show()
        freelancersService.usersList.observe(this) { freelancer ->

            if (freelancer != null) {

                adapter.setData(freelancer)
                adapter.notifyDataSetChanged()
            }
        }
    }
}