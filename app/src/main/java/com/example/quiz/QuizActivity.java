package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private Button answerButton1, answerButton2, answerButton3;
    private TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //Fragenliste initialisieren
        questionList = Question.getQuestions();

        // View Elemente initialisieren
        answerButton1 = findViewById(R.id.answerButton1);
        answerButton2 = findViewById(R.id.answerButton2);
        answerButton3 = findViewById(R.id.answerButton3);
        questionTextView = findViewById(R.id.questionTextView);

        View.OnClickListener answerClickListener = this::checkAnswer;
        answerButton1.setOnClickListener(answerClickListener);
        answerButton2.setOnClickListener(answerClickListener);
        answerButton3.setOnClickListener(answerClickListener);
        displayQuestion();
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Question currentQuestion = questionList.get(currentQuestionIndex);
            questionTextView.setText(currentQuestion.getText());
            List<String> answers = currentQuestion.getAnswers();
            answerButton1.setText(answers.get(0));
            answerButton2.setText(answers.get(1));
            answerButton3.setText(answers.get(2));
        } else {
            // Quiz beendet, zur LeaderboardActivity navigieren
            Intent intent = new Intent(QuizActivity.this, LeaderboardActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
            finish();
        }
    }

    private void checkAnswer(View view) {
        // Logik zur Überprüfung der Antwort (z. B. welche Antwort gewählt wurde):
        // Button-Text abrufen
        Button clickedButton = (Button) view;
        String selectedAnswer = clickedButton.getText().toString();

        // Richtige Antwort prüfen
        Question currentQuestion = questionList.get(currentQuestionIndex);

        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
        }

        currentQuestionIndex++;
        displayQuestion();
    }
}
