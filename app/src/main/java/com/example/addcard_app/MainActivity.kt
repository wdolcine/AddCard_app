package com.example.addcard_app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val flashcardQuestion = findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer = findViewById<TextView>(R.id.flashcard_answer)
        val flashcardAnswer1 = findViewById<TextView>(R.id.flashcard_answer1)
        val flashcardAnswer2 = findViewById<TextView>(R.id.flashcard_answer2)

        val crossMain = findViewById<View>(R.id.imageButton3)
        val editbtn   = findViewById<View>(R.id.imageButton)



        flashcardQuestion.setOnClickListener {
            flashcardQuestion.visibility = View.INVISIBLE
            flashcardAnswer.visibility = View.VISIBLE
            flashcardAnswer1.visibility = View.VISIBLE
            flashcardAnswer2.visibility = View.VISIBLE

        }


        crossMain.setOnClickListener {
            val intent = Intent(this,AddCard::class.java)
            startActivity(intent)
        }
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (result.resultCode == Activity.RESULT_OK && data != null) {
                val question = data.getStringExtra("question")
                val answer = data.getStringExtra("answer")
                val answer1 = data.getStringExtra("answer1")
                val answer2 = data.getStringExtra("answer2")

                // Mettre à jour les TextView dans MainActivity avec les nouvelles données
                flashcardQuestion.text = question
                flashcardAnswer.text = answer
                flashcardAnswer1.text = answer1
                flashcardAnswer2.text = answer2


            } else {
                Log.i("AddCardActivity", "Save operation cancelled or no data returned")
            }
        }
        editbtn.setOnClickListener {
            val question = findViewById<TextView>(R.id.flashcard_question).text.toString()
            val answer = findViewById<TextView>(R.id.flashcard_answer).text.toString()
            val answer1 = findViewById<TextView>(R.id.flashcard_answer1).text.toString()
            val answer2 = findViewById<TextView>(R.id.flashcard_answer2).text.toString()

            val intent = Intent(this, AddCard::class.java)
            intent.putExtra("question", question)
            intent.putExtra("answer", answer)
            intent.putExtra("option1", answer1)
            intent.putExtra("option2", answer2)
            resultLauncher.launch(intent)
        }

        crossMain.setOnClickListener {
            val intent = Intent(this, AddCard::class.java)
            resultLauncher.launch(intent)
        }
    }
}