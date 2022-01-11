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
import kotlinx.android.synthetic.main.activity_main.*


//TODO : tres actividades: Main Nueva Ajustes
//TODO : implementar squlite
//TODO : Crear notificaciones/Alarmas
//TODO : Crear Tema personalizado
//TODO : Si da tiempo crear un sistema de cuentas atras recurrentes (he puesto la lavadora)
val CHANNEL_ID = "CHANNEL_ID"
val ACTION_SNOOZE= "ACTION_SNOOZE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createNotificationChannel()
//        val snoozeIntent = Intent(this, MainActivity::class.java).apply {
//            action = ACTION_SNOOZE
//            putExtra(EXTRA_NOTIFICATION_ID, 0)
//        }
//        val snoozePendingIntent: PendingIntent =
//            PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)
//        val voyIntent = Intent(this, MainActivity::class.java).apply {
//            action = ACTION_SNOOZE
//            putExtra(EXTRA_NOTIFICATION_ID, 0)
//        }
//        val voyPendingIntent: PendingIntent =
//            PendingIntent.getBroadcast(this, 0, voyIntent, 0)
//        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setContentTitle("textTitle")
//            .setContentText("textContent")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .addAction(R.drawable.ic_launcher_foreground, "voy"/*getString(R.string.snooze)*/,
//                voyPendingIntent)
//            .addAction(R.drawable.ic_launcher_foreground, "Luego"/*getString(R.string.snooze)*/,
//                snoozePendingIntent)
//        val notificationId = 1
//        buttonTest.setOnClickListener{
//            with(NotificationManagerCompat.from(this)) {
//                // notificationId is a unique int for each notification that you must define
//                notify(notificationId, builder.build())
//            }
//        }

        
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal1" //getString(R.string.channel_name)
            val descriptionText = "Canal para tareas"//getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
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