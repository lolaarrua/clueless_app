package com.example.clueless.firstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import android.widget.TextView
import com.example.clueless.R

class SignupActivity : AppCompatActivity() {
    private lateinit var logTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val btncrear = findViewById<AppCompatButton>(R.id.btncrear)
        val mail = findViewById<AppCompatEditText>(R.id.mail)
        val username = findViewById<AppCompatEditText>(R.id.username)
        val contra = findViewById<AppCompatEditText>(R.id.contrasena)
        val contraconf = findViewById<AppCompatEditText>(R.id.contrasenaconf)
        logTextView = findViewById(R.id.logTextView)

        fun validateInput() {
            val mail = mail.text.toString()
            val user = username.text.toString()
            val contra = contra.text.toString()
            val contraconf = contraconf.text.toString()

            val logMessage = when {
                mail.isEmpty() || user.isEmpty() || contra.isEmpty() || contraconf.isEmpty() -> {
                    "Completar todos los campos"
                }
                mail.length >= 100 || !mail.contains("@") || !mail.contains(".") -> {
                    "El correo electrónico no es válido."
                }
                user.length >= 20 -> {
                    "El nombre de usuario es demasiado largo."
                }
                contra.length >= 20 || contraconf.length >= 20 -> {
                    "La contraseña es demasiado larga."
                }
                contra != contraconf -> {
                    "Las contraseñas no coinciden."
                }
                else -> {
                    "Cuenta creada!"
                }
            }

            logTextView.text = logMessage
            logTextView.visibility = if (logMessage.isNotEmpty()) View.VISIBLE else View.GONE

            Log.i("SignupActivity", logMessage)
        }
        btncrear.setOnClickListener {
            validateInput()
        }

    }
}


