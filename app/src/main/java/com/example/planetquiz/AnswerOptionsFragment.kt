package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswerOptionsFragment : Fragment() {

    private lateinit var question: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        question = arguments?.getString(ARG_QUESTION) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_answer_options,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText = view.findViewById<TextView>(R.id.questionText)
        questionText.text = question

        setupButton(view, R.id.mercuryButton, "MERCURY")
        setupButton(view, R.id.venusButton, "VENUS")
        setupButton(view, R.id.earthButton, "EARTH")
        setupButton(view, R.id.marsButton, "MARS")
        setupButton(view, R.id.jupiterButton, "JUPITER")
        setupButton(view, R.id.saturnButton, "SATURN")
        setupButton(view, R.id.uranusButton, "URANUS")
        setupButton(view, R.id.neptuneButton, "NEPTUNE")
    }

    private fun setupButton(view: View, buttonId: Int, answer: String) {

        val button = view.findViewById<Button>(buttonId)

        button.setOnClickListener {
            checkAnswer(answer)
        }
    }

    private fun checkAnswer(selectedAnswer: String) {

        val correctAnswer: String
        val detail: String

        when (question) {

            "What is the largest planet?" -> {
                correctAnswer = "JUPITER"
                detail = getString(R.string.jupiter_detail)
            }

            "Which planet has the most moons?" -> {
                correctAnswer = "SATURN"
                detail = getString(R.string.saturn_detail)
            }

            else -> {
                correctAnswer = "URANUS"
                detail = getString(R.string.uranus_detail)
            }
        }

        val fragment = AnswersFragment.newInstance(
            question,
            selectedAnswer,
            correctAnswer,
            detail
        )

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {

        private const val ARG_QUESTION = "question"

        fun newInstance(question: String): AnswerOptionsFragment {

            val fragment = AnswerOptionsFragment()

            val bundle = Bundle()
            bundle.putString(ARG_QUESTION, question)

            fragment.arguments = bundle

            return fragment
        }
    }
}