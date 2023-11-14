package com.example.bmi_intent_10911240

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val boy = findViewById<RadioButton>(R.id.radioButton)
        val girl = findViewById<RadioButton>(R.id.radioButton2)
        val btn_bmi = findViewById<Button>(R.id.button3)
        val vw_bmi = findViewById<TextView>(R.id.textView6)
        var Bmi = 0.0
        intent?.extras?.let {
            val Hight = it.getInt("Hight") / 100.0
            val Weight = it.getInt("Weight")
            Bmi = ((Weight / (Hight * Hight)) * 10.0).roundToInt() / 10.0
            vw_bmi.text = "BMI: ${Bmi}"
        }

        Toast.makeText(this, "您的BMI值為：${Bmi}", Toast.LENGTH_LONG).show()

        btn_bmi.setOnClickListener {
            Log.d("MainActivity", "按下確認按鈕(性別選擇)...")
            val Gender = when{
                boy.isChecked -> "先生"
                girl.isChecked -> "女士"
                else -> {
                    Toast.makeText(this, "請選擇性別", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
            val intent = Intent().putExtra("Gander", Gender).putExtra("Bmi", Bmi)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}