package com.example.ejercicio

import android.annotation.SuppressLint
import android.graphics.Color
import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var num = 0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var muestra : TextView = findViewById(R.id.muestra)
         var suma : Button = findViewById<Button>(R.id.suma)
         var resta : Button = findViewById(R.id.resta)
         var introducir : EditText = findViewById(R.id.introducir)


        introducir.setOnFocusChangeListener() {ejercicio,focuseado->
            if (focuseado){
                suma.setBackgroundColor((Color.parseColor("#52EE09")))
                resta.setBackgroundColor((Color.parseColor("#EE1E09")))
                Toast.makeText(this, "Colores cambiados", Toast.LENGTH_SHORT).show()
            }else{
                suma.setBackgroundColor((Color.parseColor("#000000")))
                resta.setBackgroundColor((Color.parseColor("#000000")))
            }
        }


        suma.setOnClickListener(){
            incrementa()
        }
        resta.setOnClickListener(){
            decrementa()
        }


    }


     fun incrementa(){

         var muestra : TextView = findViewById(R.id.muestra)
         var introducir : EditText = findViewById(R.id.introducir)
         try {
              num = introducir.getText().toString().toInt()+num
             muestra.setText(num.toString())
         }catch (e : NumberFormatException){
             0
         }

    }

    fun decrementa(){

        var muestra : TextView = findViewById(R.id.muestra)
        var introducir : EditText = findViewById(R.id.introducir)
        try {


            if (num-introducir.getText().toString().toInt()<0){
                Toast.makeText(this, "No puede ser negativo", Toast.LENGTH_SHORT).show()
            }else
                num = num-introducir.getText().toString().toInt()
                muestra.setText(num.toString())
        }catch (e : NumberFormatException){
            0
        }

    }
}