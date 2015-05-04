package com.example.chavda.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bsh.EvalError;
import bsh.Interpreter;


/**
 * Created by CHAVDA on 02-05-2015.
 */
public class MainActivity extends ActionBarActivity {

    Button btnAc, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot, btnEquel, btnSum, btnMinus, btnMulti, btnDevide;
    EditText editText;
    String strNumber = "";
    Double dblNumber = 0.0;
    boolean isdot = false;
    boolean isdotClick = true;
    String strToDisplay = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        strNumber = intent.getStringExtra("Number");
        strToDisplay = intent.getStringExtra("NumberToDisplay");

        if (strNumber == null)
            strNumber = "";


        if (strToDisplay == null)
            strToDisplay = "";


        btnAc = (Button) findViewById(R.id.btnAc);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnEquel = (Button) findViewById(R.id.btnEqual);
        btnSum = (Button) findViewById(R.id.btnSum);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDevide = (Button) findViewById(R.id.btnDevide);
        editText = (EditText) findViewById(R.id.editText);

        if (strToDisplay == null || strToDisplay == "" || strToDisplay == "0")
            editText.setText("0");
        else
            editText.setText(strToDisplay);
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber = "";
                strToDisplay = "";

                editText.setText("0");
                isdot = false;
                isdotClick = true;
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "0";
                strToDisplay += "0";
                dblNumber = 0.0;
                editText.setText(strToDisplay.replace(".0", ""));

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "1";
                strToDisplay += "1";
                dblNumber = 1.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "2";
                strToDisplay += "2";
                dblNumber = 2.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "3";
                strToDisplay += "3";
                dblNumber = 3.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "4";
                strToDisplay += "4";
                dblNumber = 4.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "5";
                strToDisplay += "5";
                dblNumber = 5.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "6";
                strToDisplay += "6";
                dblNumber = 6.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "7";
                strToDisplay += "7";
                dblNumber = 7.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "8";
                strToDisplay += "8";
                dblNumber = 8.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "9";
                strToDisplay += "9";
                dblNumber = 9.0;
                editText.setText(strToDisplay.replace(".0", ""));
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isdot = true;
                //isdotClick=true;
                if (isdotClick) {
                    strNumber += ".";
                    strToDisplay += ".";
                    isdotClick = false;
                }
                editText.setText(strToDisplay);
            }
        });

        btnEquel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Interpreter objint = new Interpreter();
                    if (strNumber.contains("^")) {

                        String strP[] = strNumber.split("\\^");
                        //String strEval = objint.eval(strNumber).toString();
                        String ans = String.valueOf(Math.pow(Double.valueOf(strP[0]), Double.valueOf(strP[1])));

                        editText.setText(ans);

                    } else {
                        if (strNumber.contains("/")) {
                            String s[] = strNumber.split("\\/");
                            strNumber = "";
                            strToDisplay = "";
                            for (int i = 0; i <= s.length - 1; i++) {
                                if (s[i].contains("*") || s[i].contains("+") || s[i].contains("-")) {
                                    strNumber += s[i] + "/";
                                } else {
                                    strNumber += String.valueOf(Double.parseDouble(s[i]));
                                }
                            }
                        }

                        if (!isdot)
                            strNumber = objint.eval("(" + strNumber + ")").toString();
                        else
                            strNumber = objint.eval("(" + strNumber + ")").toString();

                        isdot = false;
                        isdotClick = true;
                        //="7.0/8.0";
                        //System.out.println(Double.parseDouble(intre.eval("("+strNumber+")").toString()));
                        if (strNumber.length() > 3)
                            editText.setText(Double.valueOf(strNumber).toString());
                        else
                            editText.setText(String.format(strNumber));

                        strToDisplay =strNumber;
                    }
                    //strNumber=
                } catch (EvalError evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }

            }
        });
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "+";
                strToDisplay += "+";
                editText.setText(strToDisplay.replace(".0", ""));
                isdotClick = true;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "-";
                strToDisplay += "-";
                editText.setText(strToDisplay.replace(".0", ""));
                isdotClick = true;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "*";
                strToDisplay += "*";
                editText.setText(strToDisplay.replace(".0", ""));
                isdotClick = true;
            }
        });
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s[] = strNumber.split("\\/");
                Double dblVal = 0.0;

                if (s.length == 1 && strNumber.contains("/")) {
                    strNumber = "";
                    strToDisplay = "";
                    strNumber += Double.parseDouble(s[0]) + "/";
                    strToDisplay += Double.parseDouble(s[0]) + "/";
                }
                //dblVal = Double.valueOf(s[s.length-1]);
                else {
                    strNumber = "";
                    strToDisplay = "";
                    for (int i = 0; i <= s.length - 1; i++) {
                        if (s[i].contains("*") || s[i].contains("+") || s[i].contains("-")) {
                            strNumber += s[i] + "/";
                            strToDisplay += s[i] + "/";
                        } else {
                            strNumber += Double.parseDouble(s[i]) + "/";
                            strToDisplay += Double.parseDouble(s[i]) + "/";
                        }
                    }
                }

//                else {
//                    dblVal = Double.valueOf(s[0]);
//                    strNumber=dblVal+"/";
//                    strToDisplay=dblVal+"/";
//                    }


                editText.setText(strToDisplay.replace(".0", ""));
                isdotClick = true;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_advance) {
            Intent intent = new Intent(MainActivity.this, Advance.class);
            intent.putExtra("Number", strNumber);
            intent.putExtra("NumberToDisplay", strToDisplay);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
