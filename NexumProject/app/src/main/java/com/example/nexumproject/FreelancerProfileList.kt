package com.example.nexumproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.example.nexumproject.services.shared.controle.acesso.UsersService

class FreelancerProfileList : AppCompatActivity() {

    private val freelancersService: UsersService = UsersService();
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freelancer_profile_list)
        recyclerView = findViewById(R.id.list_recyclerView)
        recyclerView.adapter = adapter
    }

    fun renderList() {
        freelancersService.usersList.observe(this) { freelancer ->
            if (freelancer != null) {
                adapter.setData(freelancer)
            }
        }
    }
}