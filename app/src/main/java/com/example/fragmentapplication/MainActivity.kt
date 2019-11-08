package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOneLoaded = true
    val maneger = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(R.id.btn_frag)
        ShowFragmentOne()

        botao.setOnClickListener({
            if (isFragmentOneLoaded)
                ShowFragmenttwo()
            else
                ShowFragmentOne()

        })
    }
    fun ShowFragmentOne(){
        val transaction = maneger.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.frag,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }

    fun ShowFragmenttwo(){
        val transaction = maneger.beginTransaction()
        val fragment = Fragmenttwo()
        transaction.replace(R.id.frag,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false

    }
}
