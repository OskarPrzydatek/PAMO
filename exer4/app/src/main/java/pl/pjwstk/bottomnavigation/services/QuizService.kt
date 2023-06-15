package pl.pjwstk.bottomnavigation.services

class QuizService {
    private val questions: MutableList<Question>
    private var currentQuestionIndex: Int
    var correctAnswers: Int
        private set

    init {
        questions = ArrayList()
        currentQuestionIndex = 0
        correctAnswers = 0
        addQuestions()
    }

    private fun addQuestions() {
        questions.add(
            Question(
                "Which of the following foods is high in protein?",
                "Apples",
                "Carrots",
                "Chicken",
                "Lettuce",
                3
            )
        )
        questions.add(
            Question(
                "What is the recommended daily amount of water intake for adults?",
                "1 liter",
                "2 liters",
                "3 liters",
                "4 liters",
                2
            )
        )
        questions.add(
            Question(
                "Which of the following vitamins is important for maintaining healthy eyesight?",
                "Vitamin A",
                "Vitamin B",
                "Vitamin C",
                "Vitamin D",
                1
            )
        )
        questions.add(
            Question(
                "Which of the following activities is considered aerobic exercise?",
                "Lifting weights",
                "Running",
                "Yoga",
                "Stretching",
                2
            )
        )
        questions.add(
            Question(
                "What is the recommended amount of sleep for adults?",
                " 4-5 hours",
                "6-7 hours",
                "8-9 hours",
                "10-11 hours",
                3
            )
        )
        questions.add(
            Question(
                "Which of the following habits can improve overall mental health?",
                "Regular exercise",
                "Eating junk food",
                "Watching TV all day",
                "Not getting enough sleep",
                1
            )
        )
    }

    val currentQuestion: Question
        get() = questions[currentQuestionIndex]

    fun answerQuestion(selectedOption: Int) {
        if (selectedOption == currentQuestion.correctOption) {
            correctAnswers++
        }
        currentQuestionIndex++
    }

    val isQuizFinished: Boolean
        get() = currentQuestionIndex == questions.size
    val totalQuestions: Int
        get() = questions.size
    val quizPercentage: Double
        get() = correctAnswers.toDouble() / questions.size * 100
}