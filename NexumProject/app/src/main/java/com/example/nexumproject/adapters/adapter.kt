package com.example.nexumproject

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
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
import com.example.nexumproject.services.shared.controle.acesso.UsersService

class Adapter(private val context: Context,private var dataSet: List<Users>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val matchService: MatchService = MatchService();
    private val userService: UsersService = UsersService();
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvCidadePerfil: TextView = view.findViewById(R.id.tvCidadePerfil)
        val tvNomePerfil: TextView = view.findViewById(R.id.tvNomePerfil)
        val tvEstadoPerfil: TextView = view.findViewById(R.id.tvEstadoPerfil)
        val tvAtuacaoPerfil: TextView = view.findViewById(R.id.tvAtuacaoPerfil)
        val ivIconHeard: ImageView = view.findViewById(R.id.ivIconHeard)
        val tvTextoSobrePerfil: TextView = view.findViewById(R.id.tvTextoSobrePerfil)
        val ivFotoListaDeFrelancer: ImageView = view.findViewById(R.id.ivFotoListaDeFrelancer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.res_library_freelance_profile_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = dataSet[position + 9]
        val endereco = item.endereco
        val prefs = context.getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)
        var idContratante = id?.toLongOrNull()
        var idFreelancer = item.id_user


        holder.tvNomePerfil.text = item?.nome
        holder.tvTextoSobrePerfil.text = item?.sobre
        holder.tvCidadePerfil.text = endereco?.cidade
        holder.tvEstadoPerfil.text = endereco?.estado
        holder.tvAtuacaoPerfil.text = item?.profession
        holder.ivIconHeard.setOnClickListener{
            val match = Matches(idContratante ?: 0, idFreelancer)
            matchService.sendMatchRequest(match)
            Toast.makeText(context,"Solicitaçao de match enviada", Toast.LENGTH_SHORT).show()
        }
        userService.getImageProfile(idFreelancer)
        userService.foto.observe(context as LifecycleOwner) { foto ->
            foto?.let { bitmap ->
                val drawable: Drawable = BitmapDrawable(context.resources, bitmap)
                holder.ivFotoListaDeFrelancer.setImageDrawable(drawable)
            }
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
