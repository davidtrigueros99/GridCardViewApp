package com.example.gridcardviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private  var gvTabla:GridView? = null

    var nombre = arrayListOf<String>("Checo", "Max", "Carlos", "Charles")
    var departamento = arrayListOf<String>("Sonsonate", "Cabanas", "San Salvador", "La Paz")
    var imagenes = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )
    var imagenesLista = arrayOf(
        ImgItems(imagenes.get(0), nombre.get(0), departamento.get(0)),
        ImgItems(imagenes.get(1), nombre.get(1), departamento.get(1)),
        ImgItems(imagenes.get(2), nombre.get(2), departamento.get(2)),
        ImgItems(imagenes.get(3), nombre.get(3), departamento.get(3))
    )

    var myImagenLista = ArrayList<ImgItems>()
    var modificadorAdaptador:AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (imagen in imagenesLista){
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gv_Tabla)

        modificadorAdaptador = AdaptadorModificado(myImagenLista, this)
        gvTabla?.adapter = modificadorAdaptador

        gvTabla?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var ventana:Intent = Intent(applicationContext, Detalle::class.java)
                ventana.putExtra("imagen", imagenes.get(position))
                ventana.putExtra("nombre", nombre.get(position))
                ventana.putExtra("departamento", departamento.get(position))
                startActivity(ventana)
            }

        }
    }

    fun btnSiguiente(Vista:View){
        var ventana:Intent = Intent(applicationContext, WebViewApp::class.java)
        startActivity(ventana)
    }
}