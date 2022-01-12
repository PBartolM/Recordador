package com.example.recordador

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.EXTRA_NOTIFICATION_ID
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    private var items: ArrayList<Tarjeta>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ArrayList<Tarjeta>()

        var bdg: SQLiteGestor? = null
        bdg = SQLiteGestor(this, "recordatorios.sqlite")
        val bd = bdg.readableDatabase

        val rs = bd.rawQuery("SELECT * FROM ALARMAS", null)

        while (rs.moveToNext())
            items!!.add(Tarjeta(rs.getInt(0), rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)))

        rs.close()
        bd.close()
        bdg.close()
        val recView = findViewById(R.id.recView) as RecyclerView
        recView.setHasFixedSize(true)
        val adaptador = CardsAdapter(items!!)

        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.action_settings) -> {
                lanzarAjustes()
                return true}
            (R.id.action_add) -> {
                lanzarNuevo()
                return true}
            else -> {return super.onOptionsItemSelected(item)} }
    }

    fun lanzarAjustes(){
        val i = Intent(this,Ajustes::class.java)
        startActivity(i)
    }
    fun lanzarNuevo(){
        val i = Intent(this,Nuevo::class.java)
        startActivity(i)
    }
}