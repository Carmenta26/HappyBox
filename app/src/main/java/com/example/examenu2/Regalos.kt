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

    override fun onCreate(savedInstanceState: Bundle?) {
        var menu:ArrayList<Detalles> = ArrayList<Detalles>();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        cargarDetalles()

        adapter = DetallesAdapter(this, detalles)

        var gridView: GridView = findViewById(R.id.grdiviewDetalles)
        gridView.adapter = adapter


        var menuOption:String? =intent.getStringExtra("menuType");
        agregarProductos(menuOption)

        var detalle_text: TextView =findViewById(R.id.detalle_text)
        when(menuOption){
            "Detalles"->{
                detalle_text.setText("Detalles")
            }
            "Globos"->{
                detalle_text.setText("Globos")
            }
            "Peluches"->{
                detalle_text.setText("Peluches")
            }
            "Regalos"->{
                detalle_text.setText("Regalos")
            }
            "Tazas"->{
                detalle_text.setText("Detalles")
            }

        }


        var adaptador : AdaptadorProductos = AdaptadorProductos(this,menu,)
        listView.adapter=adaptador;

    }

    fun cargarDetalles() {
        detalles.add(Detalles(R.drawable.cumplebotanas, "Precio: $10"))
        detalles.add(Detalles(R.drawable.cumplecheve, "Precio: $15"))
        detalles.add(Detalles(R.drawable.cumplecheve, "Precio: $20"))
        detalles.add(Detalles(R.drawable.cumplecheve, "Precio: $12"))
        detalles.add(Detalles(R.drawable.cumplecheve, "Precio: $18"))
        detalles.add(Detalles(R.drawable.cumplecheve, "Precio: $25"))
    }
}

class DetallesAdapter: BaseAdapter {

    var detalles = ArrayList<Detalles>()
    var context: Context? = null

    constructor(context: Context , detalles: ArrayList<Detalles>):super() {
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
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.detalle_regalo, parent, false)
        var image: ImageView = vista.findViewById(R.id.image_detalle)
        var precio: TextView = vista.findViewById(R.id.precio)

        image.setImageResource(detalle.image)
        precio.text = detalle.precio

        return vista
    }
}
