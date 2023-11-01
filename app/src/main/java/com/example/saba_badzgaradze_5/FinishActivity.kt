package com.example.saba_badzgaradze_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinishActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val bundle = intent.extras

        textView = findViewById(R.id.textView)

        if (bundle != null) {
            val name: String? = bundle.getString("NAME")
            val lastName: String? = bundle.getString("LASTNAME")
            val personalNumber: String? = bundle.getString("PERSONALNUMBER")

            val result = "Name: $name \nLastName: $lastName \nPersonal Number: $personalNumber"
            textView.text = result
        }

    }
}