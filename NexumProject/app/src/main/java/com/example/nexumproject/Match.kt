package com.example.nexumproject


import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject


class Match : AppCompatActivity() {
    private lateinit var tvCantatoCampoNumeroDeTelefone: TextView
    private lateinit var tvCantatoCampoEmailPorExtenso: TextView
    private lateinit var tvContatoWhatsApp: TextView
    private lateinit var tvContatoEmail: TextView
    private lateinit var btnVoltar: ImageView

    private lateinit var prefs: SharedPreferences
    private var celular: String? = null
    private var email: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
        tvCantatoCampoNumeroDeTelefone = findViewById(R.id.tvCantatoCampoNumeroDeTelefone)
        tvCantatoCampoEmailPorExtenso = findViewById(R.id.tvCantatoCampoEmailPorExtenso)
        tvContatoWhatsApp = findViewById(R.id.tvContatoWhatsApp)
        tvContatoEmail = findViewById(R.id.tvContatoEmail)
        btnVoltar = findViewById(R.id.btnVoltar)
        prefs = getSharedPreferences("USER_INFO", AppCompatActivity.MODE_PRIVATE)
        celular = prefs.getString("USER_CELULAR", null)
        email = prefs.getString("USER_EMAIL", null)

setData()
        abrirWhats()
        abrirEmail()
        voltar()
    }
    fun  voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, TelaDePerfilFreelancer::class.java)
            startActivity(intent)
        }
    }
    fun setData() {

        tvCantatoCampoNumeroDeTelefone.setText(celular)
        tvCantatoCampoEmailPorExtenso.setText(email)
    }

    fun isAppInstalled(packageName: String): Boolean {
        val packageManager = this.packageManager
        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
    }

    fun abrirWhats() {
        tvContatoWhatsApp.setOnClickListener {
            if (isAppInstalled("com.whatsapp")) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://wa.me/$celular")
                startActivity(intent)
            } else {
                Toast.makeText(this, "WhatsApp não está instalado", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun abrirEmail() {
        tvContatoEmail.setOnClickListener {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do e-mail")
        intent.putExtra(Intent.EXTRA_TEXT, "Corpo do e-mail")
        startActivity(Intent.createChooser(intent, "Enviar e-mail"))
        }
    }



}