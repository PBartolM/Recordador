package com.example.recordador

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nuevo.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import android.content.ContentValues
import android.os.Build
import android.text.format.DateFormat.is24HourFormat
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.lang.Exception



class Nuevo : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo)

        timePicker1.setIs24HourView(true)
        guardar.setOnClickListener{


            var bdg: SQLiteGestor? = null
            bdg = SQLiteGestor(this, "recordatorios.sqlite")
            val bd = bdg.writableDatabase
            val bd2 = bdg.readableDatabase
            val values = ContentValues()
            val rs = bd.rawQuery("select max(id) from ALARMAS", null)
            var newId =0
            if (rs.moveToNext()){
                newId= rs.getInt(0)+1
            }


            var nombre:String
            try {
                nombre =editTextNombre.text.toString()
            } catch (e:Exception) {
                nombre = "Por defecto"
            }
            val hora=timePicker1.hour.toInt()
            val minut=timePicker1.minute.toInt()


            val lu=booleanToInt(checkBoxLu.isChecked)
            val ma=booleanToInt(checkBoxMa.isChecked)
            val mi=booleanToInt(checkBoxMi.isChecked)
            val ju=booleanToInt(checkBoxJu.isChecked)
            val vi=booleanToInt(checkBoxVi.isChecked)
            val sa=booleanToInt(checkBoxSa.isChecked)
            val dom=booleanToInt(checkBoxDo.isChecked)
            values.put("id",newId)
            values.put("nom",nombre)
            values.put("hora",hora)
            values.put("minuto",minut)
            values.put("lu",lu)
            values.put("ma",ma)
            values.put("mi",mi)
            values.put("ju",ju)
            values.put("vi",vi)
            values.put("sa",sa)
            values.put("do",dom)
            bd.insert("ALARMAS", null, values);


            bd.close()
            bdg.close()
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        cancelar.setOnClickListener{
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }

    fun booleanToInt(b: Boolean): Int {
        return if (b) 1 else 0
    }
}