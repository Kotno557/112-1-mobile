package com.example.bmi_intent_10911240

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.bmi_intent_10911240.adapter.ItemAdaptor
import com.example.bmi_intent_10911240.data.Datasource

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var bmiLevel = ""

        intent?.extras?.let {
            val tpBmiLevel = it.getString("bmiLevel")
            if (tpBmiLevel != null) {
                bmiLevel = tpBmiLevel
            }
        }

        val myDataset = Datasource().loadAffirmation(bmiLevel)
        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)

        recycleView.adapter = ItemAdaptor(this, myDataset)
        recycleView.setHasFixedSize(true)
    }
}