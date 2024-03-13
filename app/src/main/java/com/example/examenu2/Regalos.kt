package com.example.examenu2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var adapter: DetallesAdapter? = null
    var detalles = ArrayList<Detalles>()

    var menu: ArrayList<Detalles> = ArrayList<Detalles>();
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)








        var menuOption: String? = intent.getStringExtra("menuType");
        agregarProductos(menuOption)

        var detalle_text: TextView = findViewById(R.id.detalle_text)
        when (menuOption) {
            "Detalles" -> {
                detalle_text.setText("Detalles")
            }

            "Globos" -> {
                detalle_text.setText("Globos")
            }

            "Peluches" -> {
                detalle_text.setText("Peluches")
            }

            "Regalos" -> {
                detalle_text.setText("Regalos")
            }

            "Tazas" -> {
                detalle_text.setText("Tazas")
            }

        }


        var gridView: GridView = findViewById(R.id.grdiviewDetalles)
        gridView.adapter = adapter


        var adaptador: DetallesAdapter = DetallesAdapter(this, menu)
        gridView.adapter = adaptador;

    }

    fun agregarProductos(option: String?) {


        when (option) {
            "Detalles" -> {
                menu.add(Detalles(R.drawable.cumplebotanas, "$280"))
                menu.add(Detalles(R.drawable.cumplecheve, "$280"))
                menu.add(Detalles(R.drawable.cumpleescolar, "$280"))
                menu.add(Detalles(R.drawable.cumplepaletas, "$280"))
                menu.add(Detalles(R.drawable.cumplesnack, "$280"))
                menu.add(Detalles(R.drawable.cumplevinos, "$280"))

                // Agrega más detalles según sea necesario
            }

            "Globos" -> {
                menu.add(Detalles(R.drawable.globocumple, "$280"))
                menu.add(Detalles(R.drawable.globoamor, "$280"))
                menu.add(Detalles(R.drawable.globofestejo, "$280"))
                menu.add(Detalles(R.drawable.globos, "$280"))
                menu.add(Detalles(R.drawable.globonum, "$280"))
                menu.add(Detalles(R.drawable.globonum, "$280"))
                menu.add(Detalles(R.drawable.globoregalo, "$280"))
            }

            "Peluches" -> {
                menu.add(Detalles(R.drawable.peluchemario, "$280"))
                menu.add(Detalles(R.drawable.pelucheminecraft, "$280"))
                menu.add(Detalles(R.drawable.peluchepeppa, "$280"))
                menu.add(Detalles(R.drawable.peluches, "$280"))
                menu.add(Detalles(R.drawable.peluchesony, "$280"))
                menu.add(Detalles(R.drawable.peluchestich, "$280"))
                menu.add(Detalles(R.drawable.peluchevarios, "$280"))
            }

            "Regalos" -> {
                menu.add(Detalles(R.drawable.regalos, "$280"))
                menu.add(Detalles(R.drawable.regaloazul, "$280"))
                menu.add(Detalles(R.drawable.regalobebe, "$280"))
                menu.add(Detalles(R.drawable.regalocajas, "$280"))
                menu.add(Detalles(R.drawable.regalocolores, "$280"))
                menu.add(Detalles(R.drawable.regalovarios, "$280"))
                menu.add(Detalles(R.drawable.globoregalo, "$280"))
            }

            "Tazas" -> {
                menu.add(Detalles(R.drawable.tazaabuela, "$280"))
                menu.add(Detalles(R.drawable.tazalove, "$280"))
                menu.add(Detalles(R.drawable.tazaquiero, "$280"))
                menu.add(Detalles(R.drawable.tazas, "$280"))

            }

            else -> {
                // Maneja una opción no válida si es necesario
            }
        }

    }

    class DetallesAdapter : BaseAdapter {

        var detalles = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, detalles: ArrayList<Detalles>) : super() {
            this.detalles = detalles
            this.context = context
        }

        override fun getCount(): Int {
            return detalles.size
        }

        override fun getItem(position: Int): Any {
            return detalles[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var detalle = detalles[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var vista = inflator.inflate(R.layout.detalle_regalo, parent, false)
            var image: ImageView = vista.findViewById(R.id.image_detalle)
            var precio: TextView = vista.findViewById(R.id.precio)

            image.setImageResource(detalle.image)
            precio.text = detalle.precio

            return vista
        }
    }
}
