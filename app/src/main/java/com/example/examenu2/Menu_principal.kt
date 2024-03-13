package com.example.examenu2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class Menu_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)



        val buttonDetalles: Button = findViewById(R.id.button_detalles)
        val buttonGlobos: Button = findViewById(R.id.button_globos)
        val buttonPeluches: Button = findViewById(R.id.button_peluches)
        val buttonRegalos: Button = findViewById(R.id.button_regalos)
        val buttonTazas: Button = findViewById(R.id.button_tazas)

        buttonDetalles.setOnClickListener {
            val intent = Intent(this, ProductosActivity::class.java)
            intent.putExtra("menuType", "Detalles")
            startActivity(intent)
        }


        // Agrega listeners para los otros botones del menú de manera similar
    }
}