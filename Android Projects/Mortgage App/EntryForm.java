package com.example.user.mcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);
    }

    public void buttonClicked(View v){
        EditText principleView = (EditText) findViewById(R.id.principleBox);
        String principle = principleView.getText().toString();

        EditText amortView = (EditText) findViewById(R.id.amortBox);
        String amort = amortView.getText().toString();

        EditText interestView = (EditText) findViewById(R.id.interestBox);
        String interest = interestView.getText().toString();

        MortgageModel myModel = new MortgageModel(principle, amort, interest);
        String payment = myModel.computePayment();

        ((TextView) findViewById(R.id.result)).setText(payment);
    }
}

