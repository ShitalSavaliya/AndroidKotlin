package com.mathsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mathsdemo.sqliteDB.DBHandler
import com.mathsdemo.sqliteDB.Question
import com.mathsdemo.sqliteDB.User
import kotlin.random.Random


class QuestionActivity : AppCompatActivity() {

    private lateinit var mTvIndex: TextView
    private lateinit var mTvQuestion: TextView
    private lateinit var mRGQuestion: RadioGroup
    private lateinit var mRBOne: RadioButton
    private lateinit var mRBTwo: RadioButton
    private lateinit var mRBThree: RadioButton
    private lateinit var mRBFour: RadioButton
    private lateinit var mRBFive: RadioButton
    private lateinit var mBtnNext: Button
    private lateinit var name: String
    private var counter: Int = 1
    private var score: Int = 0
    private var totalQuestion: Int = 14
    private lateinit var currentAnswer: String
    private var selectedRandomQuizQuestions: MutableList<Int> = mutableListOf()
    private var questions: MutableList<Question> = mutableListOf()
    private lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        getIntentData()
        initUI()
        setListener()
        initDB()
        getSQLiteData()
        selectedRandomQuizQuestions = select14QuizQuestionFromList()
        fillQuestionData()
    }

    private fun initDB() {
        // creating a new DB Handler class
        // and passing our context to it.
        dbHandler = DBHandler(this)
    }

    private fun getIntentData() {
        intent?.let {
            name = it.getStringExtra("NAME") ?: ""
        }
    }

    private fun getSQLiteData() {
        // on below line we are calling a method to get data
        // question to sqlite data.
        questions = dbHandler.readCourses()
    }

    private fun select14QuizQuestionFromList(): MutableList<Int> {

        var randomInt: Int
        val pickedInt: MutableSet<Int> = mutableSetOf()
        val selectedQuiz: MutableList<Int> = mutableListOf()

        fun rand(from: Int, to: Int): Int {
            do {
                randomInt = Random.nextInt(to - from) + from
            } while (pickedInt.contains(randomInt))

            pickedInt.add(randomInt)
            return randomInt
        }

        while (pickedInt.size < 2) {
            val differentNumber = rand(1, 6)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(7, 12)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(13, 18)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(19, 24)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(25, 30)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(31, 36)
            selectedQuiz.add(differentNumber)
        }
        pickedInt.clear()
        while (pickedInt.size < 2) {
            val differentNumber = rand(37, 42)
            selectedQuiz.add(differentNumber)
        }
        return selectedQuiz
    }

    private fun select5QuizOptionFromList(data: MutableList<String>): MutableList<String> {

        var randomInt: Int
        val pickedInt: MutableSet<Int> = mutableSetOf()
        val selectedQuiz: MutableList<String> = mutableListOf()

        fun rand(from: Int, to: Int): Int {
            do {
                randomInt = Random.nextInt(to - from) + from
            } while (pickedInt.contains(randomInt))

            pickedInt.add(randomInt)
            return randomInt
        }

        while (pickedInt.size < 5) {
            val differentNumber = rand(1, 8)
            selectedQuiz.add(data[differentNumber])
        }
        return if (currentAnswer in selectedQuiz) {
            selectedQuiz
        } else {
            selectedQuiz[2] = currentAnswer
            selectedQuiz
        }
    }

    private fun setListener() {
        mBtnNext.setOnClickListener {
            val answerRadioButtonId: Int = mRGQuestion.checkedRadioButtonId
            if (answerRadioButtonId != -1) {
                val answer = findViewById<RadioButton>(answerRadioButtonId)
                if (answer.text == currentAnswer) {
                    score += 1
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.correct_answer),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        resources.getString(R.string.incorrect_answer),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                when (counter) {
                    15 -> {
                        dbHandler.addNewUser(
                            User(
                                name,
                                "${System.currentTimeMillis() / 1000L}",
                                "$score"
                            )
                        )

                        MaterialAlertDialogBuilder(this)
                            .setCancelable(false)
                            .setTitle("Score: $score/$totalQuestion")
                            .setPositiveButton(getString(R.string.finish)) { _, _ ->
                                startActivity(Intent(this,ScoreActivity::class.java))
                                finish()
                            }
                            .show()
                    }
                    14 -> {
                        mBtnNext.text = getString(R.string.finish)
                        fillQuestionData()
                    }
                    else -> {
                        fillQuestionData()
                    }
                }

            } else {
                Toast.makeText(
                    applicationContext,
                    resources.getString(R.string.missing_answer),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun initUI() {
        mTvIndex = findViewById(R.id.tv_index)
        mTvQuestion = findViewById(R.id.tv_question)
        mRGQuestion = findViewById(R.id.rg_question)
        mBtnNext = findViewById(R.id.btn_next)
        mRBOne = findViewById(R.id.rb_one)
        mRBTwo = findViewById(R.id.rb_two)
        mRBThree = findViewById(R.id.rb_three)
        mRBFour = findViewById(R.id.rb_four)
        mRBFive = findViewById(R.id.rb_five)
    }

    private fun fillQuestionData() {
        val index = selectedRandomQuizQuestions[counter-1]

        mTvQuestion.text = questions[index].question
        currentAnswer = questions[index].answer

        fillOptions(questions[index])


        mRGQuestion.clearCheck()



        mTvIndex.text = getString(R.string._que_index, counter)

        counter += 1
    }

    private fun fillOptions(question: Question) {
        val options : MutableList<String> = mutableListOf()
        options.add(question.option1)
        options.add(question.option2)
        options.add(question.option3)
        options.add(question.option4)
        options.add(question.option5)
        options.add(question.option6)
        options.add(question.option7)
        options.add(question.option8)

        val selectedRandOptions = select5QuizOptionFromList(options)

        mRBOne.text = selectedRandOptions[0]
        mRBTwo.text = selectedRandOptions[1]
        mRBThree.text = selectedRandOptions[2]
        mRBFour.text = selectedRandOptions[3]
        mRBFive.text = selectedRandOptions[4]
    }
}