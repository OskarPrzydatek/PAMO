package pl.pjwstk.bottomnavigation.ui.quiz;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Locale;

import pl.pjwstk.bottomnavigation.R;
import pl.pjwstk.bottomnavigation.services.Question;
import pl.pjwstk.bottomnavigation.services.QuizService;
import pl.pjwstk.bottomnavigation.ui.quiz.QuizViewModel;

public class QuizFragment extends Fragment {

    private QuizViewModel mViewModel;
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private QuizService quizService;

    public static QuizFragment newInstance() {
        return new QuizFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        questionTextView = root.findViewById(R.id.questionTextView);
        optionsRadioGroup = root.findViewById(R.id.optionsRadioGroup);
        submitButton = root.findViewById(R.id.submitButton);

        quizService = new QuizService();

        displayQuestion(root);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedOptionRadioButton = root.findViewById(selectedOptionId);
                    int selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton) + 1;
                    quizService.answerQuestion(selectedOption);

                    if (quizService.isQuizFinished()) {
                        // Quiz is done - Show results
                        showQuizResults();
                    } else {
                        // Render another question
                        displayQuestion(root);
                    }
                }
            }
        });

        return root;
    }


    private void displayQuestion(View root) {
        Question currentQuestion = quizService.getCurrentQuestion();
        questionTextView.setText(currentQuestion.getQuestionText());
        RadioButton[] optionRadioButtons = new RadioButton[4];
        optionRadioButtons[0] = root.findViewById(R.id.option1RadioButton);
        optionRadioButtons[1] = root.findViewById(R.id.option2RadioButton);
        optionRadioButtons[2] = root.findViewById(R.id.option3RadioButton);
        optionRadioButtons[3] = root.findViewById(R.id.option4RadioButton);
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i].setText(currentQuestion.getOptions()[i]);
        }
        optionsRadioGroup.clearCheck();
    }

    private void showQuizResults() {
        int correctAnswers = quizService.getCorrectAnswers();
        int totalQuestions = quizService.getTotalQuestions();
        double quizPercentage = quizService.getQuizPercentage();
        String results = String.format(Locale.getDefault(), "Result: %d/%d (%.2f%%)", correctAnswers, totalQuestions, quizPercentage);
        questionTextView.setText(results);
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setEnabled(false);
    }
}