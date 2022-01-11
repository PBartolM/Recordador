package com.example.recordador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.BitmapFactory


class CardsAdapter(private val items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardsAdapter.TarjViewHolder>() {

    inner class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val text: TextView
        private val tiempo: TextView

        private val lunes: TextView
        private val martes: TextView
        private val miercoles: TextView
        private val jueves: TextView
        private val viernes: TextView
        private val sabado: TextView
        private val domingo: TextView

        init {

            tiempo = itemView.findViewById(R.id.tiempo)
            text = itemView.findViewById(R.id.titulo)
            lunes =itemView.findViewById(R.id.lunes)
            martes =itemView.findViewById(R.id.martes)
            miercoles =itemView.findViewById(R.id.miercoles)
            jueves =itemView.findViewById(R.id.jueves)
            viernes =itemView.findViewById(R.id.viernes)
            sabado =itemView.findViewById(R.id.sabado)
            domingo =itemView.findViewById(R.id.sabado)

        }

        fun bindCards(t: Tarjeta) {
            //imagen.setImageResource(t.imag)
            //TODO aqui
            text.text = t.titulo
            var aux = "${ t.hora } : ${ t.minuto }"
            tiempo.text=aux

        }
        fun dias(a:TextView,b:Boolean){
            if (b){
                a.colo
            }else{

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items[pos]
        viewHolder.bindCards(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}