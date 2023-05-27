package com.example.nexumproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.nexumproject.domainobjects.Endereco
import com.example.nexumproject.models.request.shared.controle.acesso.Matches
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService
import com.example.nexumproject.services.shared.controle.acesso.MatchService

class Adapter(private val context: Context,private var dataSet: List<Users>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val matchService: MatchService = MatchService();
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvCidadePerfil: TextView = view.findViewById(R.id.tvCidadePerfil)
        val tvNomePerfil: TextView = view.findViewById(R.id.tvNomePerfil)
        val tvEstadoPerfil: TextView = view.findViewById(R.id.tvEstadoPerfil)
        val tvAtuacaoPerfil: TextView = view.findViewById(R.id.tvAtuacaoPerfil)
        val ivIconHeard: ImageView = view.findViewById(R.id.ivIconHeard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.res_library_freelance_profile_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = dataSet[position]
        val endereco = item.endereco
        val prefs = context.getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)
        var idContratante = id?.toLongOrNull()
        var idFreelancer = item.id_user


        holder.tvNomePerfil.text = item?.nome
        holder.tvCidadePerfil.text = endereco?.cidade
        holder.tvEstadoPerfil.text = endereco?.estado
        holder.tvAtuacaoPerfil.text = item?.profession
        holder.ivIconHeard.setOnClickListener{
            val match = Matches(idContratante ?: 0, idFreelancer)
            matchService.sendMatchRequest(match)
            Toast.makeText(context, matchService.usersList.toString(), Toast.LENGTH_SHORT).show()
        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    fun setData(newData: List<Users>) {
        dataSet = newData
        notifyDataSetChanged()
    }

}
