package com.example.quiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        supportFragmentManager.commit {
            replace<QuizFragment>(R.id.quiz_fragment)
        }
        setContentView(R.layout.activity_second)
    }

}
