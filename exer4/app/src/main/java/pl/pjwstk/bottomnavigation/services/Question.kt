package pl.pjwstk.bottomnavigation.services

class Question(
    val questionText: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int
) {

    val options: Array<String>
        get() = arrayOf(option1, option2, option3, option4)
}