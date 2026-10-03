package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(
            R.layout.fragment_questions,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val question1 = view.findViewById<Button>(R.id.question1Button)
        val question2 = view.findViewById<Button>(R.id.question2Button)
        val question3 = view.findViewById<Button>(R.id.question3Button)

        question1.setOnClickListener {
            openAnswers("What is the largest planet?")
        }

        question2.setOnClickListener {
            openAnswers("Which planet has the most moons?")
        }

        question3.setOnClickListener {
            openAnswers("Which planet spins on its side?")
        }
    }

    private fun openAnswers(question: String) {

        val fragment = AnswerOptionsFragment.newInstance(question)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}