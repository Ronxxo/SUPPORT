package com.ronxxo.myrural

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ronxxo.myrural.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var message: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculateNotes()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.info -> {
                message = AlertDialog.Builder(this)
                message.setTitle("Como sacar tu nota!")
                    .setMessage("Debes colocar el rango entre 0 y 50, si tienes 3,5 debes poner 35, ademas, debes llenar todos los campos de las notas para ver tu calificacion")
                    .setPositiveButton("Ok") { dialog, id ->
                    }
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun calculateNotes() {
        binding.CALCULAR.setOnClickListener {

            try {
                val n1: Int = binding.nota1.text.toString().toInt()
                val n2: Int = binding.nota2.text.toString().toInt()
                val n3: Int = binding.nota3.text.toString().toInt()
                val n4: Int = binding.nota4.text.toString().toInt()
                val n5: Int = binding.nota5.text.toString().toInt()
                val n6: Int = binding.Nota6.text.toString().toInt()

                val sum = n1 + n2 + n3 + n4 + n5 + n6
                val result = sum / 6

                binding.resultado.text = result.toString()
                binding.resultado.visibility = View.VISIBLE
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "$e", Toast.LENGTH_SHORT)
            }

        }
    }
}