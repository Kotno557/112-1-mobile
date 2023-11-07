package com.example.bmi_intent_10911240.data

import com.example.bmi_intent_10911240.R
import com.example.bmi_intent_10911240.model.Affirmation

class Datasource {
    fun loadAffirmation(bmiLevel: String): List<Affirmation> {
        return when (bmiLevel) {
            "過輕" -> {
                listOf<Affirmation>(
                    Affirmation(R.string.thin_step1, R.drawable.thin_step1),
                    Affirmation(R.string.thin_step2, R.drawable.thin_step2),
                    Affirmation(R.string.thin_step3, R.drawable.thin_step3),
                    Affirmation(R.string.thin_step4, R.drawable.thin_step4),
                    Affirmation(R.string.thin_step5, R.drawable.thin_step5),
                )
            }
            "健康" -> {
                listOf<Affirmation>(
                    Affirmation(R.string.healthy_step1, R.drawable.healthy_step1),
                    Affirmation(R.string.healthy_step2, R.drawable.healthy_step2),
                    Affirmation(R.string.healthy_step3, R.drawable.healthy_step3),
                    Affirmation(R.string.healthy_step4, R.drawable.healthy_step4),
                    Affirmation(R.string.healthy_step5, R.drawable.healthy_step5),
                )
            }
            "過重" -> {
                listOf<Affirmation>(
                    Affirmation(R.string.weight_step1, R.drawable.weight_step1),
                    Affirmation(R.string.weight_step2, R.drawable.weight_step2),
                    Affirmation(R.string.weight_step3, R.drawable.weight_step3),
                    Affirmation(R.string.weight_step4, R.drawable.weight_step4),
                    Affirmation(R.string.weight_step5, R.drawable.weight_step5),
                )
            }
            "超重" -> {
                listOf<Affirmation>(
                    Affirmation(R.string.overWeight_step1, R.drawable.over_weight_step1),
                    Affirmation(R.string.overWeight_step2, R.drawable.over_weight_step2),
                    Affirmation(R.string.overWeight_step3, R.drawable.over_weight_step3),
                    Affirmation(R.string.overWeight_step4, R.drawable.over_weight_step4),
                    Affirmation(R.string.overWeight_step5, R.drawable.over_weight_step5),
                )
            }
            else -> {
                throw IllegalArgumentException("Invalid BMI level: $bmiLevel")
            }
        }
    }
}
