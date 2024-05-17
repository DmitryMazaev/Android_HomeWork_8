package com.example.quiz

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.quiz.databinding.FragmentQuizBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_PARAM1 = "param1"
const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var quastions = Quastions()
    private var count: Int = 0
    var res: String = ""

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    private fun addQuastionsAndAnswer() {
        quastions.addAnswwer()
        quastions.addRightAnswer()
        binding.rb11.text = resources.getStringArray(R.array.quastion_one_array)[0]
        binding.rb12.text = resources.getStringArray(R.array.quastion_one_array)[1]
        binding.rb13.text = resources.getStringArray(R.array.quastion_one_array)[2]
        binding.rb14.text = resources.getStringArray(R.array.quastion_one_array)[3]
        binding.rb21.text = resources.getStringArray(R.array.quastion_two_array)[0]
        binding.rb22.text = resources.getStringArray(R.array.quastion_two_array)[1]
        binding.rb23.text = resources.getStringArray(R.array.quastion_two_array)[2]
        binding.rb24.text = resources.getStringArray(R.array.quastion_two_array)[3]
        binding.rb31.text = resources.getStringArray(R.array.quastion_three_array)[0]
        binding.rb32.text = resources.getStringArray(R.array.quastion_three_array)[1]
        binding.rb33.text = resources.getStringArray(R.array.quastion_three_array)[2]
        binding.rb34.text = resources.getStringArray(R.array.quastion_three_array)[3]
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
        _binding = FragmentQuizBinding.inflate(inflater)
        addQuastionsAndAnswer()
        radioGroupAction()
        binding.radioGrop1.animate().apply {
            duration = 3000
            alpha(1f)
        }
        binding.radioGrop2.animate().apply {
            duration = 3000
            alpha(1f)
        }
        binding.radioGrop3.animate().apply {
            duration = 3000
            alpha(1f)
        }
        binding.btnSend.setOnClickListener {
            val bundle = Bundle().apply {
                putString(ARG_PARAM1, count.toString())
                putString(ARG_PARAM2, res)
            }
            findNavController().navigate(R.id.action_QuizFragment_to_Resultfragment, bundle)
            onDestroyView()
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_QuizFragment_to_Previewfragment)
            onDestroyView()
        }
        return binding.root
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

    private fun radioGroupAction () {
        binding.radioGrop1.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb1_1 -> quastions.myAnswer[0] = 0
                R.id.rb1_2 -> quastions.myAnswer[0] = 1
                R.id.rb1_3 -> quastions.myAnswer[0] = 2
                R.id.rb1_4 -> quastions.myAnswer[0] = 3
            }
            check()
            //binding.countDelete.text = check().toString()
        }
        binding.radioGrop2.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb2_1 -> quastions.myAnswer[1] = 0
                R.id.rb2_2 -> quastions.myAnswer[1] = 1
                R.id.rb2_3 -> quastions.myAnswer[1] = 2
                R.id.rb2_4 -> quastions.myAnswer[1] = 3
            }
            check()
            //binding.countDelete.text = check().toString()
        }
        binding.radioGrop3.setOnCheckedChangeListener{_, buttonId ->
            when (buttonId) {
                R.id.rb3_1 -> quastions.myAnswer[2] = 0
                R.id.rb3_2 -> quastions.myAnswer[2] = 1
                R.id.rb3_3 -> quastions.myAnswer[2] = 2
                R.id.rb3_4 -> quastions.myAnswer[2] = 3
            }
            check()
            //binding.countDelete.text = check().toString()
        }
    }
    private fun check(){
        count = 0
        for(i in 0 until quastions.rightAnswers.size) {
            if (quastions.rightAnswers.get(i) == quastions.myAnswer[i]) {
                count +=1
            }
        }
        result()
        //binding.countDelete.text = count.toString()
    }
    private fun result() {
        if (count == 0) {
            res = resources.getStringArray(R.array.result_array)[0]
        }
        if (count == 1) {
            res = resources.getStringArray(R.array.result_array)[1]
        }
        if (count == 2) {
            res = resources.getStringArray(R.array.result_array)[2]
        }
        if (count == 3) {
            res = resources.getStringArray(R.array.result_array)[3]
        }
    }
}