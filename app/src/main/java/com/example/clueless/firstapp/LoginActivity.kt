package com.example.clueless.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.clueless.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val btnIniciar = findViewById<AppCompatButton>(R.id.btnIniciar)
        val username = findViewById<AppCompatEditText>(R.id.username)
        val contrasena = findViewById<AppCompatEditText>(R.id.contrasena)
        val crearcuenta = findViewById<TextView>(R.id.crearcuenta)

        btnIniciar.setOnClickListener{
            val user = username.text.toString()
            val contra = contrasena.text.toString()
            if(user.isNotEmpty() && user.length < 20) {
                if(contra.isNotEmpty()) {
                    //y si existe en la bdd, pero todavía no esta vinculada
                    Log.i("inicio de sesion", "bienvenido: ${username.text.toString()}")
                    //y te manda a la pantalla de inicio
                }
            }
            else{
                Log.i("no se puede ingresar", "la cuenta no existe")
            }
        }
        crearcuenta.setOnClickListener(){
            //ir a la pantalla de crear tu cuenta
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        }
    }


