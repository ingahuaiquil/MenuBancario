package com.example.menubancario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.menubancario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var saldo=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener{
            when (binding.radioGroup.checkedRadioButtonId){
                R.id.radioButtonSaldo -> binding.textMonto.setText(saldo.toString())
                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()

            }
        }
    }

    private fun retirarSaldo(){
        val monto = binding.textMonto.text.toString().toInt()
        if(monto <= saldo){
            saldo-=monto
            binding.textMonto.text.clear()
            Toast.makeText(applicationContext,"El retiro ha sido realizado", Toast.LENGTH_LONG).show()
        }
        else {
        Toast.makeText(applicationContext,"El monto supera el saldo inicial", Toast.LENGTH_LONG).show()
        }
    }

    fun ingresarSaldo(){
        saldo=binding.textMonto.text.toString().toInt()
        limpiarMonto()
        Toast.makeText(applicationContext,"Su saldo ha sido actualizado", Toast.LENGTH_LONG).show()
    }

    fun limpiarMonto(){
        binding.textMonto.text.clear()
    }
}