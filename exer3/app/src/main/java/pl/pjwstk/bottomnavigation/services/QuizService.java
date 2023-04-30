package pl.pjwstk.bottomnavigation.services;

import java.util.ArrayList;
import java.util.List;

import pl.pjwstk.bottomnavigation.services.Question;

public class QuizService {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;

    public QuizService() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        correctAnswers = 0;
        addQuestions();
    }

    private void addQuestions() {
        questions.add(new Question("Which of the following foods is high in protein?", "Apples", "Carrots", "Chicken", "Lettuce", 3));
        questions.add(new Question("What is the recommended daily amount of water intake for adults?", "1 liter", "2 liters", "3 liters", "4 liters", 2));
        questions.add(new Question("Which of the following vitamins is important for maintaining healthy eyesight?", "Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D", 1));
        questions.add(new Question("Which of the following activities is considered aerobic exercise?", "Lifting weights", "Running", "Yoga", "Stretching", 2));
        questions.add(new Question("What is the recommended amount of sleep for adults?", " 4-5 hours", "6-7 hours", "8-9 hours", "10-11 hours", 3));
        questions.add(new Question("Which of the following habits can improve overall mental health?", "Regular exercise", "Eating junk food", "Watching TV all day", "Not getting enough sleep", 1));
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestionIndex);
    }

    public void answerQuestion(int selectedOption) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++;
        }
        currentQuestionIndex++;
    }

    public boolean isQuizFinished() {
        return currentQuestionIndex == questions.size();
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public double getQuizPercentage() {
        return (double) correctAnswers / questions.size() * 100;
    }
}