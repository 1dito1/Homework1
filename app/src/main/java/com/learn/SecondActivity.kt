package com.learn

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var buttonClear: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        registerListeners()
        loadData()
    }

    private fun loadData() {
        val email = intent.getStringExtra("email")
        val message = intent.getStringExtra("message")

        editTextEmail.setText(email)
        editTextMessage.setText(message)
    }

    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonClear = findViewById(R.id.buttonClear)
    }

    private fun registerListeners() {
        buttonClear.setOnClickListener {
            editTextEmail.text?.clear()
            editTextMessage.text?.clear()
        }
    }
}