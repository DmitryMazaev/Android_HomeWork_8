package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentQuizBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var quastions = Quastions()

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    fun addQuastionsAndAnswer() {
        quastions.addAnswwer()
        quastions.addRightAnswer()
        binding.rb11.text = quastions.answer1.answerOne.toString()
        binding.rb12.text = quastions.answer1.answerTwo.toString()
        binding.rb13.text = quastions.answer1.answerThree.toString()
        binding.rb14.text = quastions.answer1.answerFour.toString()
        binding.rb21.text = quastions.answer2.answerOne.toString()
        binding.rb22.text = quastions.answer2.answerTwo.toString()
        binding.rb23.text = quastions.answer2.answerThree.toString()
        binding.rb24.text = quastions.answer2.answerFour.toString()
        binding.rb31.text = quastions.answer3.answerOne.toString()
        binding.rb32.text = quastions.answer3.answerTwo.toString()
        binding.rb33.text = quastions.answer3.answerThree.toString()
        binding.rb34.text = quastions.answer3.answerFour.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*binding.radioGrop1.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb1_1 -> quastions.rightAnswers.add(0, 0)
                R.id.rb1_2 -> quastions.rightAnswers.add(0, 1)
                R.id.rb1_3 -> quastions.rightAnswers.add(0, 2)
                R.id.rb1_4 -> quastions.rightAnswers.add(0, 3)
            }
        }
        binding.radioGrop2.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb2_1 -> quastions.rightAnswers.add(1, 0)
                R.id.rb2_2 -> quastions.rightAnswers.add(1, 1)
                R.id.rb2_3 -> quastions.rightAnswers.add(1, 2)
                R.id.rb2_4 -> quastions.rightAnswers.add(1, 3)
            }
        }
        binding.radioGrop3.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb3_1 -> quastions.rightAnswers.add(1, 0)
                R.id.rb3_2 -> quastions.rightAnswers.add(1, 1)
                R.id.rb3_3 -> quastions.rightAnswers.add(1, 2)
                R.id.rb3_4 -> quastions.rightAnswers.add(1, 3)
            }
        }*/

        // Inflate the layout for this fragment
        _binding = FragmentQuizBinding.inflate(inflater)
        addQuastionsAndAnswer()
        binding.btnSend.setOnClickListener {
            findNavController().navigate(R.id.action_QuizFragment_to_Resultfragment)
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}