package com.example.bmi_intent_10911240

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val boy = findViewById<RadioButton>(R.id.radioButton)
        val girl = findViewById<RadioButton>(R.id.radioButton2)
        val btnBmi = findViewById<Button>(R.id.button3)
        val vwBmi = findViewById<TextView>(R.id.textView6)
        var bmi = 0.0
        intent?.extras?.let {
            val height = it.getInt("Height") / 100.0
            val weight = it.getInt("Weight")
            bmi = ((weight / (height * height)) * 10.0).roundToInt() / 10.0
            vwBmi.text = "BMI: $bmi"
        }

        btnBmi.setOnClickListener {
            val gender = when{
                boy.isChecked -> "先生"
                girl.isChecked -> "女士"
                else -> {
                    Toast.makeText(this, "請選擇性別", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
            val intent = Intent().putExtra("Gander", gender).putExtra("Bmi", bmi)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}