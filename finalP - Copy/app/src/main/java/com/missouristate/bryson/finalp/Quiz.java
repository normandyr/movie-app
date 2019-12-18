package com.missouristate.bryson.finalp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import static com.missouristate.bryson.finalp.QuizInfo.*;

public class Quiz extends Activity {
    TextView movie;
    TextView question;
    TextView choices;
    TextView points;
    RadioGroup rGroup;
    RadioGroup rGroup2;
    RadioButton rButton2;
    RadioButton rButton;
    QuizInfo qq;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizview);
        movie = findViewById(R.id.movie);
        question = findViewById(R.id.qq);
        points = findViewById(R.id.points);
        choices = findViewById(R.id.choices);
        rGroup = findViewById(R.id.rb_group1);
        rGroup2 = findViewById(R.id.rb_group2);

        rGroup.setOnCheckedChangeListener(movielistener);
        rGroup2.setOnCheckedChangeListener(anlistener);
        qq = new QuizInfo();

    }


    private RadioGroup.OnCheckedChangeListener movielistener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            rButton = findViewById(radioId);
            String RadioSid = rButton.getText().toString();
            for (int i = 0; i < movies.length; i++) {
                if (RadioSid.equals(movies[i])) {
                    qq.setMovie(i);

                }

            }

            String x = qq.getMovie();
            movie.setText((x));

            qq.setQuestions(x);
            qq.setQuestion();
            String q = qq.getQuestion();
            question.setText(q);
            qq.setchoices();
            qq.setAnswer();

            choices.setText("Please select from " + qq.getChoices());
        };};

    private RadioGroup.OnCheckedChangeListener anlistener = new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            rButton2 = findViewById(radioId);
            String RadioSid = rButton2.getText().toString();
            for (int i = 0; i < movies.length; i++) {
                if (RadioSid.equals(qq.getAnswer())) {
                    qq.setScore(1);
                    break;

                }

            }

            String x = qq.getScore();
            qq.resetAnswer();
            points.setText(x);

            movie.setText(("Current Movie"));
            question.setText("Quiz Question");
            choices.setText("Possible Choices");
            rButton2.setChecked(false);
            rButton.setChecked(false);
        };};}
