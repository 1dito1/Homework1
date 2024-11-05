package com.learn

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSendMessage: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        registerListeners()
    }

    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextMessage = findViewById(R.id.editTextMessage)
        buttonSendMessage = findViewById(R.id.buttonSendMessage)
    }

    private fun registerListeners() {
        buttonSendMessage.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val message = editTextMessage.text.toString().trim()

            if (email.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please enter email and message.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!email.contains("@")) {
                Toast.makeText(this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sendMessage()
        }
    }

    private fun sendMessage() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("email", editTextEmail.text.toString())
        intent.putExtra("message", editTextMessage.text.toString())
        startActivity(intent)
    }
}
