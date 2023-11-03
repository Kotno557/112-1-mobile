package com.example.bmi_intent_10911240

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextInputEditText>(R.id.textInputEditText1)
        val inputHeight = findViewById<TextInputEditText>(R.id.textInputEditText2)
        val inputWeight = findViewById<TextInputEditText>(R.id.textInputEditText3)
        val result = findViewById<TextView>(R.id.textView7)
        val suggestion = findViewById<TextView>(R.id.textView8)
        val btnBmi = findViewById<Button>(R.id.button2)
        val btnSuggest = findViewById<Button>(R.id.button)

        var bmiLevel = ""

        val getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            if (it.resultCode == Activity.RESULT_OK){
                val gander = it.data?.getStringExtra("Gander")
                var bmi = it.data?.getDoubleExtra("Bmi", -1.0)
                if(bmi == null){
                    bmi = -1.0
                }

                result.text = "結果:\n" + "${name.text.toString()}${gander}您好 \n" + "您的 BMI 數值為: $bmi"
                when {
                    bmi < 18.5  -> {
                        suggestion.text = "「體重過輕」，需要多運動，均衡飲食，以增加體能，維持健康！"
                        bmiLevel = "過輕"
                    }
                    bmi >= 18.5 && bmi < 24 -> {
                        suggestion.text = "恭喜！「健康體重」，要繼續保持！"
                        bmiLevel = "健康"
                    }
                    bmi >= 24 && bmi < 27 -> {
                        suggestion.text = "「體重過重」了，要小心囉，趕快力行「健康體重管理」！"
                        bmiLevel = "過重"
                    }
                    bmi >= 27 -> {
                        suggestion.text = "啊～「肥胖」，需要立刻力行「健康體重管理」囉！"
                        bmiLevel = "超重"
                    }
                    else -> {
                        suggestion.text = "數值為負，請重新輸入數值喔~"
                        bmiLevel = "數值錯誤"
                    }
                }
            }
        }

        btnBmi.setOnClickListener {
            val hight: Int
            val weight: Int
            try {
                hight  = inputHeight.text.toString().toInt()
                weight  = inputWeight.text.toString().toInt()
            }
            catch (e: NumberFormatException){
                Toast.makeText(this, "數值輸入錯誤或未輸入", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putInt("Height", hight)
            bundle.putInt("Weight", weight)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            getResult.launch(intent)
        }

        btnSuggest.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("bmiLevel", bmiLevel)

            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}