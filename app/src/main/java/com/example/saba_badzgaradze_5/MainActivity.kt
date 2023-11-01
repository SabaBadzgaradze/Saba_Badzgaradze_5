package com.example.saba_badzgaradze_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    private lateinit var dateTextView: TextView
    private val timeUpdateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            updateDateTime()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)

        button.setOnClickListener {

            val name = editText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME", name)
            startActivity(intent)
        }

        dateTextView = findViewById(R.id.dateTextView)

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(timeUpdateReceiver, intentFilter)

        updateDateTime()
    }

    private fun updateDateTime() {
        val currentTime = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(Date())
        dateTextView.text = "$currentTime"
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeUpdateReceiver)
    }
}