package com.example.nexumproject

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.services.shared.controle.acesso.MatchService
import com.example.nexumproject.services.shared.controle.acesso.UsersService

class AdapterProposta(private val context: Context,private var dataSet: List<Users>) : RecyclerView.Adapter<AdapterProposta.ViewHolder>() {
    private val matchService: MatchService = MatchService();
    private val userService: UsersService = UsersService();
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvNomeProposta: TextView = view.findViewById(R.id.tvNomeProposta)
        val tvEstadoProposta: TextView = view.findViewById(R.id.tvEstadoProposta)
        val tvCidadeProposta: TextView = view.findViewById(R.id.tvCidadeProposta)
        val tvTextoSobrePerfil: TextView = view.findViewById(R.id.tvTextoSobrePerfil)
        val etEmail: TextView = view.findViewById(R.id.etEmail)
        val ivIconHeard: ImageView = view.findViewById(R.id.ivIconHeard)
        val ivFotoProposta: ImageView = view.findViewById(R.id.ivFotoProposta)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.res_library_proposal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = dataSet[position]
        val endereco = item.endereco
        val prefs = context.getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)
        var id_freelancer = id?.toLongOrNull() ?: 0
        var id_contratante =  item?.id_user ?: 0

        holder.tvNomeProposta.text = item?.nome
        holder.tvCidadeProposta.text = endereco?.cidade
        holder.tvEstadoProposta.text = endereco?.estado
        holder.tvTextoSobrePerfil.text = item?.sobre
        holder.etEmail.text = item?.email
        holder.ivIconHeard.setOnClickListener{
            val intent = Intent(holder.itemView.context, Match::class.java)
            holder.itemView.context.startActivity(intent)

            matchService.putMatchRequest(id_freelancer, id_contratante)
            Toast.makeText(context, "Match realizado com sucesso", Toast.LENGTH_SHORT).show()

            val prefs = context.getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
            val editor = prefs.edit()

            editor.putString("USER_EMAIL",  item?.email.toString())
            editor.putString("USER_CELULAR",  item?.celular.toString())
            editor.apply()


        }

        userService.getImageProfile(id_contratante)
        userService.foto.observe(context as LifecycleOwner) { foto ->
            foto?.let { bitmap ->
                val drawable: Drawable = BitmapDrawable(context.resources, bitmap)
                holder.ivFotoProposta.setImageDrawable(drawable)
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
