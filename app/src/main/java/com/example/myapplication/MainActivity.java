package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });


    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is\n"+currentScore + "\10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
     private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted : "+questionAttempted + "/10");
        if(questionAttempted == 10){
            showBottomSheet();
        }else {


            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }

     }
     private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
         quizModalArrayList.add(new QuizModal("How GFG i used?", "To solve DSA Problems", "To  learn Android", "To learn new languages", "All of these", "All of these"));
         quizModalArrayList.add(new QuizModal("What is GCM in Android?", "Google Cloud Messaging", "Google Message Pack", "Google Cloud Manager", "All of the above", "Google Cloud Manager"));
         quizModalArrayList.add(new QuizModal("What is ADB in Android", "Android Debug Bridge", "Android data bridge", "Android Database Bridge", "All of these", "Android Debug Bridge"));
         quizModalArrayList.add(new QuizModal("Wnat are colors present in Android", "colors.xml", "AndroidManifest.xml", "strings.xml", "All of the above", "colors.xml"));
         quizModalArrayList.add(new QuizModal("Under which of the following Android is licensed?", "OSS", "Sourceforge", "Apache/MIT", "None of the above", "Apache/MIT"));
         quizModalArrayList.add(new QuizModal("For which of the following Android is mainly developed?", "Servers", "Desktops", "Laptops", "Mobile devices", "Mobile devices"));
         quizModalArrayList.add(new QuizModal("Which of the following virtual machine is used by the Android operating system?", "JVM", "Dalvik virtual machine", "Simple virtual machine", "None of the above", "Dalvik virtual machine"));
         quizModalArrayList.add(new QuizModal("APK stands for?", "Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above", "Android Package Kit"));
         quizModalArrayList.add(new QuizModal("What does API stand for?","Application Programming Interface","Android Programming Interface","Android Page Interface","Application Page Interface","Application Programming Interface"));
         quizModalArrayList.add(new QuizModal( "NDK stands for ?","Native Development Kit","New Development kit","Native Design Kit","None of the above","Native Development Kit"));
     }

}