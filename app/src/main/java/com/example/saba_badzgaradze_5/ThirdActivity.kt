package com.example.saba_badzgaradze_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThirdActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val bundle = intent.extras

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)

        var name: String? = ""
        var lastName: String? = ""

        if (bundle != null) {
            name = bundle.getString("NAME")
            lastName = bundle.getString("LASTNAME")
        }

        button.setOnClickListener {

            val personalNumber = editText.text.toString()

            val intent = Intent(this,FinishActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("LASTNAME",lastName)
            intent.putExtra("PERSONALNUMBER", personalNumber)
            startActivity(intent)

        }

    }
}