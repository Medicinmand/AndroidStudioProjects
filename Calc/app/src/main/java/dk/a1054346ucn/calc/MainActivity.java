package dk.a1054346ucn.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dk.a1054346ucn.calc.controller.CalcController;
import dk.a1054346ucn.calc.controller.ICalcController;

public class MainActivity extends AppCompatActivity {
    String displayMessage ="";
    ICalcController cCtr = new CalcController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText displayField = (EditText) findViewById(R.id.editText);
        Button btn0 = (Button) findViewById(R.id.button0);
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        Button btn8 = (Button) findViewById(R.id.button8);
        Button btn9 = (Button) findViewById(R.id.button9);
        Button btnAdd = (Button) findViewById(R.id.buttonAdd);
        Button btnCalc = (Button) findViewById(R.id.buttonClac);
        Button btnKomma = (Button) findViewById(R.id.buttonKomma);
        Button btnDivide = (Button) findViewById(R.id.buttonDivide);
        Button btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button btnSubtract = (Button) findViewById(R.id.buttonSubtract);
        Button btnClear = (Button) findViewById(R.id.buttonClear);

        btn0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="0";
                displayField.setText(displayMessage);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="1";
                displayField.setText(displayMessage);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="2";
                displayField.setText(displayMessage);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="3";
                displayField.setText(displayMessage);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="4";
                displayField.setText(displayMessage);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="5";
                displayField.setText(displayMessage);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="6";
                displayField.setText(displayMessage);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="7";
                displayField.setText(displayMessage);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="8";
                displayField.setText(displayMessage);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+="9";
                displayField.setText(displayMessage);
            }
        });

        btnKomma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+=".";
                displayField.setText(displayMessage);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+=" + ";
                displayField.setText(displayMessage);
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+=" - ";
                displayField.setText(displayMessage);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+=" / ";
                displayField.setText(displayMessage);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage+=" * ";
                displayField.setText(displayMessage);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayMessage="";
                displayField.setText(displayMessage);
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String result = cCtr.calculate(displayMessage);
                displayField.setText(result);
            }
        });


    }
}
