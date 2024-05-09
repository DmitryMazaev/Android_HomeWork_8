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
import com.example.quiz.databinding.FragmentQuizBinding


class SecondActivity : AppCompatActivity() {
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}
