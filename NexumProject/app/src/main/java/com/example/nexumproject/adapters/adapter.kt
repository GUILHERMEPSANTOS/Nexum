package com.example.nexumproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nexumproject.domainobjects.Endereco
import com.example.nexumproject.models.response.shared.role.Users

class Adapter(private var dataSet: List<Users>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCidadePerfil: TextView = view.findViewById(R.id.tvCidadePerfil)
        val tvNomePerfil: TextView = view.findViewById(R.id.tvNomePerfil)
        val tvEstadoPerfil: TextView = view.findViewById(R.id.tvEstadoPerfil)
        val tvAtuacaoPerfil: TextView = view.findViewById(R.id.tvAtuacaoPerfil)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.res_library_freelance_profile_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        val endereco = item.endereco
        holder.tvNomePerfil.text = item?.nome
        holder.tvCidadePerfil.text = endereco?.cidade
        holder.tvEstadoPerfil.text = endereco?.estado
        holder.tvAtuacaoPerfil.text = item?.profession
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    fun setData(newData: List<Users>) {
        dataSet = newData
        notifyDataSetChanged()
    }

}
