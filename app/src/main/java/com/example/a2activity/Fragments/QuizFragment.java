package com.example.a2activity.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a2activity.Email;
import com.example.a2activity.Models.IntrebariPitesti;
import com.example.a2activity.R;

public class QuizFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    public QuizFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    RadioGroup rg1;
    RadioButton raspADam,raspBDam,raspCDam,raspDDam;
    Button btnNextDam;
    TextView tvScorDam,tvIntrebareDam,tvNrINTR;

    int score=0;
    int totalQuestion= IntrebariPitesti.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_quiz, container, false);


        tvIntrebareDam = view.findViewById(R.id.tvIntrebare);
        tvScorDam = view.findViewById(R.id.tvScor);
        tvNrINTR=view.findViewById(R.id.tvNrINTR);



        raspADam = view.findViewById(R.id.btnRaspA);
        raspBDam = view.findViewById(R.id.btnRaspB);
        raspCDam = view.findViewById(R.id.btnRaspC);
        raspDDam = view.findViewById(R.id.btnRaspD);
        btnNextDam =view. findViewById(R.id.btnNext);
        rg1=view.findViewById(R.id.rg1);

        raspADam.setOnClickListener(this);
        raspBDam.setOnClickListener(this);
        raspCDam.setOnClickListener(this);
        raspDDam.setOnClickListener(this);
        btnNextDam.setOnClickListener(this);

        tvNrINTR.setText("Total questions : "+totalQuestion);

        loadNewQuestion();

        return view;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnNext){
            rg1.clearCheck();
            if(selectedAnswer.equals(IntrebariPitesti.correctAnswers[currentQuestionIndex])){
                score++;
                tvScorDam.setText("Scor:"+score);

            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            selectedAnswer  = clickedButton.getText().toString();

        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        else {
            tvIntrebareDam.setText(IntrebariPitesti.question[currentQuestionIndex]);
            raspADam.setText(IntrebariPitesti.choices[currentQuestionIndex][0]);
            raspBDam.setText(IntrebariPitesti.choices[currentQuestionIndex][1]);
            raspCDam.setText(IntrebariPitesti.choices[currentQuestionIndex][2]);
            raspDDam.setText(IntrebariPitesti.choices[currentQuestionIndex][3]);
        }
    }

    void finishQuiz(){
        String passStatus = "";
        if(score >totalQuestion*0.60){
            passStatus = "Passed";
            new AlertDialog.Builder(getActivity())
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score +" out of "+ totalQuestion)
                    .setPositiveButton("Email",((dialogInterface, i) ->goHome()))
                    .setCancelable(false)
                    .show();
        }else{
            passStatus = "Failed";
            new AlertDialog.Builder(getActivity())
                    .setTitle(passStatus)
                    .setMessage("Score is "+ score+" out of "+ totalQuestion)
                    .setPositiveButton("Email",(dialogInterface, i) -> goHome() )
                    .setCancelable(true)
                    .show();
            btnNextDam.setEnabled(false);
        }

    }

    private void goHome() {
        Intent intent = new Intent(getActivity(), Email.class);
        intent.putExtra("score", score);
        startActivity(intent);
        btnNextDam.setEnabled(false);
    }



}