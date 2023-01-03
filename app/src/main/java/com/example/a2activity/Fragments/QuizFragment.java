package com.example.a2activity.Fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a2activity.Models.Email;
import com.example.a2activity.Models.IntrebariPitesti;
import com.example.a2activity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    RadioGroup rg1;
    RadioButton raspADam,raspBDam,raspCDam,raspDDam;
    Button btnNextDam;
    TextView tvScorDam,tvIntrebareDam,tvNrINTR;
    private EditText eTo, eSubject, eMsg;
    Button btn;

    int score=0;
    int totalQuestion= IntrebariPitesti.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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

        //setContentView(R.layout.activity_email);
        eTo = (EditText)view.findViewById(R.id.txtTo);
        eSubject = (EditText)view.findViewById(R.id.txtSub);
        eMsg = (EditText)view.findViewById(R.id.txtMsg);
        btn = (Button)view.findViewById(R.id.btnSend);

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
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            //  rg1.clearCheck();

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
                    .setCancelable(false)
                    .show();
        }

    }

    private void goHome() {
        Intent intent = new Intent(getActivity(), Email.class);
        intent.putExtra("score", score);
        startActivity(intent);

    }


 /*  @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }*/
}