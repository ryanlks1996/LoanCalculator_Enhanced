package my.edu.tarc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextView textViewDisplay;
    EditText editTextSalary;
    EditText editTextPrice;
    EditText editTextDownPayment;
    EditText editTextRepayment;
    EditText editTextInterest;
    public static final String DOWNPAYMENT = "MainActivity.downPayment" ;
    public static final String REPAYMENT = "MainActivity.repayment" ;
    public static final String INTERESTRATE = "MainActivity.interestRate" ;
    public static final String MONTHPAYMENT = "MainActivity.monthPayment" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDisplay = (TextView) findViewById(R.id.textViewDisplay);
        editTextSalary = (EditText) findViewById(R.id.editTextSalary);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        editTextDownPayment = (EditText) findViewById(R.id.editTextDownPayment);
        editTextRepayment = (EditText) findViewById(R.id.editTextRepayment);
        editTextInterest = (EditText) findViewById(R.id.editTextInterest);

    }

    public void checkLoanStatus(View v){
        double interestRate =  Double.parseDouble(editTextInterest.getText().toString());
        int salary = Integer.parseInt(editTextSalary.getText().toString());
        int price = Integer.parseInt(editTextPrice.getText().toString());
        int downPayment = Integer.parseInt(editTextDownPayment.getText().toString());
        int repayment = Integer.parseInt(editTextRepayment.getText().toString());


        double totalInterest = (price-downPayment) * interestRate * (repayment/12);
        double totalLoan = (price-downPayment)+totalInterest;
        double monthPayment = totalLoan / repayment;

        if(monthPayment > (salary*0.3))
            textViewDisplay.setText("Status: Reject");
        else
            textViewDisplay.setText("Status: Accept");




        Intent intent = new Intent(this,ResultDisplay.class);
        intent.putExtra(DOWNPAYMENT,downPayment);
        intent.putExtra(REPAYMENT,repayment);
        intent.putExtra(INTERESTRATE,interestRate);
        intent.putExtra(MONTHPAYMENT,monthPayment);

        startActivity(intent);


    }
    public void clearText(View v){

        textViewDisplay.setText("");
        editTextSalary.setText("");
        editTextPrice.setText("");
        editTextDownPayment.setText("");
        editTextRepayment.setText("");
        editTextInterest.setText("");

    }
}
