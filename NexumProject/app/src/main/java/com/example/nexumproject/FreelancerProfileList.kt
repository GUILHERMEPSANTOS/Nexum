package com.example.nexumproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView

class FreelancerProfileList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freelancer_profile_list)

        recyclerView = findViewById(R.id.list_recyclerView)
        val dados = listOf("", "")
        adapter = Adapter(dados)

        recyclerView.adapter = adapter
    }
}