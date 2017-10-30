package my.edu.tarc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);
        TextView downPayment = (TextView) findViewById(R.id.downPayment);
        TextView repayment = (TextView) findViewById(R.id.repayment);
        TextView interestRate = (TextView) findViewById(R.id.interestRate);
        TextView monthPayment = (TextView) findViewById(R.id.monthPayment);

        //Identify the intent that trigger this activity
        Intent intent = getIntent();
        int downPayment1 = intent.getIntExtra(MainActivity.DOWNPAYMENT,0);
        int repayment1 = intent.getIntExtra(MainActivity.REPAYMENT,0);
        double interestRate1 = intent.getDoubleExtra(MainActivity.INTERESTRATE,0);
        double monthPayment1 = intent.getDoubleExtra(MainActivity.MONTHPAYMENT,0);
        downPayment.setText("Down Payment: "+downPayment1);
        repayment.setText("Repayment: "+repayment1);
        interestRate.setText("Interest Rate: "+interestRate1);
        monthPayment.setText("Monthly Payment: "+monthPayment1);

    }


}