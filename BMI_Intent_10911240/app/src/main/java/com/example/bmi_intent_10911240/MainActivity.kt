package com.example.bmi_intent_10911240

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        val hight = findViewById<TextInputEditText>(R.id.textInputEditText2)
        val weight = findViewById<TextInputEditText>(R.id.textInputEditText3)
        val result = findViewById<TextView>(R.id.textView7)
        val suggestion = findViewById<TextView>(R.id.textView8)
        val btn_bmi = findViewById<Button>(R.id.button2)


        val getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            if (it.resultCode == Activity.RESULT_OK){
                val Gander = it.data?.getStringExtra("Gander")
                var Bmi = it.data?.getDoubleExtra("Bmi", -1.0)
                if(Bmi == null){
                    Bmi = -1.0
                }

                result.text = "結果:\n" + "${name.text.toString()}${Gander}您好 \n" + "您的 BMI 數值為: ${Bmi}"
                suggestion.text = "建議: \n" + when{
                    Bmi < 18.5  -> {
                        "「體重過輕」，需要多運動，均衡飲食，以增加體能，維持健康！"
                    }
                    Bmi >= 18.5 && Bmi < 24 -> {
                        "恭喜！「健康體重」，要繼續保持！"
                    }
                    Bmi >= 24 && Bmi < 27 -> {
                        "「體重過重」了，要小心囉，趕快力行「健康體重管理」！"
                    }
                    Bmi >= 27 -> {
                        "啊～「肥胖」，需要立刻力行「健康體重管理」囉！"
                    }
                    else -> {
                        "數值為負，請重新輸入數值喔~"
                    }
                }
            }
        }

        btn_bmi.setOnClickListener {
            val Hight: Int
            val Weight: Int
            try {
                Hight  = hight.text.toString().toInt()
                Weight  = weight.text.toString().toInt()
            }
            catch (e: NumberFormatException){
                Toast.makeText(this, "數值輸入錯誤或未輸入", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val bundle = Bundle()
            bundle.putInt("Hight", Hight)
            bundle.putInt("Weight", Weight)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            getResult.launch(intent)
        }
    }
}