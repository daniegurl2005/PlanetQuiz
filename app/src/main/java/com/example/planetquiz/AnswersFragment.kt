package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswersFragment : Fragment() {

    private lateinit var question: String
    private lateinit var selectedAnswer: String
    private lateinit var correctAnswer: String
    private lateinit var detail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        question = arguments?.getString(ARG_QUESTION) ?: ""
        selectedAnswer = arguments?.getString(ARG_SELECTED) ?: ""
        correctAnswer = arguments?.getString(ARG_CORRECT) ?: ""
        detail = arguments?.getString(ARG_DETAIL) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_answers,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText = view.findViewById<TextView>(R.id.answerQuestion)
        val resultText = view.findViewById<TextView>(R.id.resultText)
        val correctText = view.findViewById<TextView>(R.id.correctAnswerText)
        val detailText = view.findViewById<TextView>(R.id.detailText)
        val backButton = view.findViewById<Button>(R.id.backButton)

        questionText.text = question

        if (selectedAnswer == correctAnswer) {
            resultText.text = "CORRECT!"
        } else {
            resultText.text = "WRONG!"
        }

        correctText.text = "Correct answer: $correctAnswer"
        detailText.text = detail

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {

        private const val ARG_QUESTION = "question"
        private const val ARG_SELECTED = "selected"
        private const val ARG_CORRECT = "correct"
        private const val ARG_DETAIL = "detail"

        fun newInstance(
            question: String,
            selectedAnswer: String,
            correctAnswer: String,
            detail: String
        ): AnswersFragment {

            val fragment = AnswersFragment()

            val bundle = Bundle()

            bundle.putString(ARG_QUESTION, question)
            bundle.putString(ARG_SELECTED, selectedAnswer)
            bundle.putString(ARG_CORRECT, correctAnswer)
            bundle.putString(ARG_DETAIL, detail)

            fragment.arguments = bundle

            return fragment
        }
    }
}