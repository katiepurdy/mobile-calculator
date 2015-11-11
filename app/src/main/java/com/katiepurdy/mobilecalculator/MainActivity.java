package com.katiepurdy.mobilecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    protected String mInputString = "0";
    protected char mLastOperator = ' ';
    protected String mResult = "0";
    protected String mDigit = "0";
    protected String mResultToReverse ="0";

    protected TextView mResultDisplay;
    protected Button mButtonNum0;
    protected Button mButtonNum1;
    protected Button mButtonNum2;
    protected Button mButtonNum3;
    protected Button mButtonNum4;
    protected Button mButtonNum5;
    protected Button mButtonNum6;
    protected Button mButtonNum7;
    protected Button mButtonNum8;
    protected Button mButtonNum9;
    protected Button mButtonAdd;
    protected Button mButtonSubtract;
    protected Button mButtonMultiply;
    protected Button mButtonDivide;
    protected Button mButtonDecimal;
    protected Button mButtonCalculate;
    protected Button mButtonReverseSign;
    protected Button mButtonClear;
    protected Button mButtonBackspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to the TextView that displays the result
        mResultDisplay = (TextView) findViewById(R.id.textResult);

        // Get reference to the calculator buttons
        mButtonNum0 = (Button) findViewById(R.id.buttonNumber0);
        mButtonNum1 = (Button) findViewById(R.id.buttonNumber1);
        mButtonNum2 = (Button) findViewById(R.id.buttonNumber2);
        mButtonNum3 = (Button) findViewById(R.id.buttonNumber3);
        mButtonNum4 = (Button) findViewById(R.id.buttonNumber4);
        mButtonNum5 = (Button) findViewById(R.id.buttonNumber5);
        mButtonNum6 = (Button) findViewById(R.id.buttonNumber6);
        mButtonNum7 = (Button) findViewById(R.id.buttonNumber7);
        mButtonNum8 = (Button) findViewById(R.id.buttonNumber8);
        mButtonNum9 = (Button) findViewById(R.id.buttonNumber9);
        mButtonAdd = (Button) findViewById(R.id.buttonAdd);
        mButtonSubtract = (Button) findViewById(R.id.buttonSubtract);
        mButtonMultiply = (Button) findViewById(R.id.buttonMultiply);
        mButtonDivide = (Button) findViewById(R.id.buttonDivide);
        mButtonDecimal = (Button) findViewById(R.id.buttonDecimal);
        mButtonCalculate = (Button) findViewById(R.id.buttonCalculate);
        mButtonReverseSign = (Button) findViewById(R.id.buttonNegPos);
        mButtonClear = (Button) findViewById(R.id.buttonClear);
        mButtonBackspace = (Button) findViewById(R.id.buttonBackspace);

        // Create a new OnClickListener for all of the buttons
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                // Get the ID of the button that was pressed
                switch (button.getId()) {
                    // Numbers 0-9
                    case R.id.buttonNumber0:
                    case R.id.buttonNumber1:
                    case R.id.buttonNumber2:
                    case R.id.buttonNumber3:
                    case R.id.buttonNumber4:
                    case R.id.buttonNumber5:
                    case R.id.buttonNumber6:
                    case R.id.buttonNumber7:
                    case R.id.buttonNumber8:
                    case R.id.buttonNumber9:
                        mDigit = ((Button) button).getText().toString();
                        if (mInputString == "0") {
                            mInputString = mDigit;
                        } else {
                            mInputString += mDigit;
                        }
                        mResultDisplay.setText(mInputString);
                        if (mLastOperator == '=') {
                            mResult = "0";
                            mLastOperator = ' ';
                        }
                        break;
                    // Operators
                    case R.id.buttonAdd:
                        mResult = Calculations.calculate(mLastOperator, mResult, mInputString);
                        mResultDisplay.setText(mResult);
                        mInputString = "0";
                        mLastOperator = '+';
                        break;
                    case R.id.buttonSubtract:
                        mResult = Calculations.calculate(mLastOperator, mResult, mInputString);
                        mResultDisplay.setText(mResult);
                        mInputString = "0";
                        mLastOperator = '-';
                        break;
                    case R.id.buttonMultiply:
                        mResult = Calculations.calculate(mLastOperator, mResult, mInputString);
                        mResultDisplay.setText(mResult);
                        mInputString = "0";
                        mLastOperator = 'x';
                        break;
                    case R.id.buttonDivide:
                        mResult = Calculations.calculate(mLastOperator, mResult, mInputString);
                        mResultDisplay.setText(mResult);
                        mInputString = "0";
                        mLastOperator = '/';
                        break;
                    case R.id.buttonCalculate:
                        mResult = Calculations.calculate(mLastOperator, mResult, mInputString);
                        mResultDisplay.setText(mResult);
                        if (mLastOperator != '=') {
                            mResultToReverse = mResult;
                            mInputString = "0";
                        }
                        mResultToReverse = mResult;
                        mLastOperator = '=';
                        break;
                    // Other buttons (clear, reverse sign, decimal, and backspace)
                    case R.id.buttonClear:
                        mInputString = "0";
                        mLastOperator = ' ';
                        mResult = "0";
                        mResultDisplay.setText(mResult);
                        break;
                    case R.id.buttonNegPos:
                        if (mInputString != "0" || mLastOperator == '=') {
                            mInputString = Calculations.reverseSign(mResultToReverse);
                            mResultDisplay.setText(mInputString);
                        }
                        break;
                    case R.id.buttonDecimal:
                        if (!mInputString.contains(".")) {
                            mInputString = Calculations.appendDecimal(mInputString);
                        }
                        mResultDisplay.setText(mInputString);
                        break;
                    case R.id.buttonBackspace:
                        if ((mInputString != "0") && (mInputString !="NaN") && (mInputString.length()) != 1) {
                            mInputString = mInputString.substring(0, mInputString.length() - 1);
                            mResultDisplay.setText(mInputString);
                        } else if (mInputString.length() == 1) {
                            mInputString = "0";
                            mResultDisplay.setText(mInputString);
                        } else if (mInputString == "NaN") {
                            mInputString = "0";
                            mResultDisplay.setText(mInputString);
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        // Set the OnClickListener to the buttons to listen for touch input
        mButtonNum0.setOnClickListener(listener);
        mButtonNum1.setOnClickListener(listener);
        mButtonNum2.setOnClickListener(listener);
        mButtonNum3.setOnClickListener(listener);
        mButtonNum4.setOnClickListener(listener);
        mButtonNum5.setOnClickListener(listener);
        mButtonNum6.setOnClickListener(listener);
        mButtonNum7.setOnClickListener(listener);
        mButtonNum8.setOnClickListener(listener);
        mButtonNum9.setOnClickListener(listener);
        mButtonAdd.setOnClickListener(listener);
        mButtonSubtract.setOnClickListener(listener);
        mButtonMultiply.setOnClickListener(listener);
        mButtonDivide.setOnClickListener(listener);
        mButtonDecimal.setOnClickListener(listener);
        mButtonCalculate.setOnClickListener(listener);
        mButtonReverseSign.setOnClickListener(listener);
        mButtonClear.setOnClickListener(listener);
        mButtonBackspace.setOnClickListener(listener);
    }
}
