package com.example.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }

    }

    private fun calculate() {
        if (validationOk()) {
            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPreco.text.toString().toFloat()
                val autonomy = editAutonomia.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"
            }catch (nfe: NumberFormatException){
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {
        return (editDistance.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != ""
                && editAutonomia.text.toString() != "0")

    }
}
