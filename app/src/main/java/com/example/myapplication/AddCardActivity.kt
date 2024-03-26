package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView

class AddCardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val crossAddCard = findViewById<ImageView>(R.id.imageView4)
        val savebtn = findViewById<ImageView>(R.id.imageView5)
        val editTextField =findViewById<EditText>(R.id.editTextText)
        val editTextField1 =findViewById<EditText>(R.id.editTextText2)

        crossAddCard.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        savebtn.setOnClickListener {
            val question = editTextField.text.toString()
            val answer = editTextField1.text.toString()

            val intent = Intent()
            intent.putExtra("question", question)
            intent.putExtra("answer", answer)
            setResult(Activity.RESULT_OK,intent)
            finish()

        }
    }


}