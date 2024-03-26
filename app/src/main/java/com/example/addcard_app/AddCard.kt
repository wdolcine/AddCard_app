package com.example.addcard_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class AddCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_card)
        val crossAddCard = findViewById<ImageView>(R.id.imageView4)
        val savebtn = findViewById<ImageView>(R.id.imageView5)
        val editTextField =findViewById<EditText>(R.id.editTextText)
        val editTextField1 =findViewById<EditText>(R.id.editTextText2)
        val editTextField2 =findViewById<EditText>(R.id.editTextText3)
        val editTextField3 =findViewById<EditText>(R.id.editTextText4)


        crossAddCard.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        val question = intent.getStringExtra("question")
        val answer = intent.getStringExtra("answer")
        val answer1 = intent.getStringExtra("answer1")
        val answer2 = intent.getStringExtra("answer2")

        editTextField.setText(question)
        editTextField1.setText(answer)
        editTextField2.setText(answer1)
        editTextField3.setText(answer2)

        savebtn.setOnClickListener {
            val question = editTextField.text.toString()
            val answer = editTextField1.text.toString()
            val answer1 = editTextField2.text.toString()
            val answer2 = editTextField3.text.toString()

            if(question.isBlank() || answer.isBlank() || answer1.isBlank() || answer2.isBlank() ){
                Snackbar.make(findViewById(R.id.imageView5), "Veuillez remplir tous les champs", Snackbar.LENGTH_SHORT).show()
            } else{
                Snackbar.make(findViewById(R.id.imageView5), "Card succesful Created", Snackbar.LENGTH_SHORT).show()

                val intent = Intent()
                intent.putExtra("question", question)
                intent.putExtra("answer", answer)
                intent.putExtra("answer1", answer1)
                intent.putExtra("answer2", answer2)


                setResult(Activity.RESULT_OK,intent)
                finish()
            }



        }
    }
}