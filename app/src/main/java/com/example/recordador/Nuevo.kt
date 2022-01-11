package com.example.recordador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

//TODO: implemtentar squlite
//TODO: campos :Nombre, Hora, Frequencia (si da tiempo flexibilidad)
//TODO: implementar sistema avanzado de frecuencia
//TODO: Asegurar los inputs
class Nuevo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo)

        guardar.setOnClickListener{
            val nombre=editTextNombre.text
            val str: String = editTextHora.getText().toString()
            val formatter: DateFormat = SimpleDateFormat("hh:mm:ss a")
            val date: Date = formatter.parse(str)
        }
        cancelar.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}