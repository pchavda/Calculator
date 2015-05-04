package com.example.chavda.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
public class Advance extends ActionBarActivity {
    Button btnsin, btncos, btntan, btnbi, btnln, btnlog, btnpi, btne, btnmod, btnroot, btnexp, btnfact, btnAc, btnsb, btncb, btnEqual, btnbx;
    EditText editText;
    String strNumber = "";
    String strToDisplay = "";
    boolean blIsExp = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advance);

        Intent intent = getIntent();
        strNumber = intent.getStringExtra("Number");
        strToDisplay = intent.getStringExtra("NumberToDisplay");
        btnAc = (Button) findViewById(R.id.btnAc);
        editText = (EditText) findViewById(R.id.editText);
        editText.setText(strToDisplay);
        btnsin = (Button) findViewById(R.id.btnsin);
        btncos = (Button) findViewById(R.id.btncos);
        btntan = (Button) findViewById(R.id.btntan);
        btnbi = (Button) findViewById(R.id.btnbi);
        btnln = (Button) findViewById(R.id.btnln);
        btnpi = (Button) findViewById(R.id.btnpi);
        btne = (Button) findViewById(R.id.btne);
        btnlog = (Button) findViewById(R.id.btnlog);
        btnmod = (Button) findViewById(R.id.btnmod);
        btnroot = (Button) findViewById(R.id.btnroot);
        btnexp = (Button) findViewById(R.id.btnexp);
        btnfact = (Button) findViewById(R.id.btnfact);
        btnsb = (Button) findViewById(R.id.btnsb);
        btncb = (Button) findViewById(R.id.btncb);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnbx = (Button) findViewById(R.id.btnbx);

        if(strNumber == null || strNumber.equals(""))
        {
            editText.setText("0");
        }
        btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber = "";
                strToDisplay = "";

                editText.setText("0");

            }
        });

        btnsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "(";
                strToDisplay += "(";
                editText.setText(strNumber);

            }
        });

        btncb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += ")";
                strToDisplay += ")";
                editText.setText(strNumber);

            }
        });

        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber= (String.valueOf(Math.asin(Math.toRadians(Double.parseDouble(strEval)))).substring(0, 4));
                    strToDisplay = strNumber;
                    editText.setText(strNumber);

                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }

            }
        });

        btncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber =(String.valueOf(Math.acos(Math.toRadians(Double.parseDouble(strEval)))).substring(0, 4));
                    strToDisplay = strNumber;
                            editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }
            }
        });

        btntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber = (String.valueOf(Math.atan(Math.toRadians(Double.parseDouble(strEval)))).substring(0, 4));
                    strToDisplay = strNumber;
                    editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }

            }
        });

        btnbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber =(String.valueOf(Math.log(Double.parseDouble(strEval))));
                    strToDisplay = strNumber;
                    editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber = strToDisplay = (String.valueOf(Math.log10(Double.parseDouble(strEval))));
                    editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }
            }
        });

        btnpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    strNumber = strToDisplay = (String.valueOf(Math.PI)).substring(0, 4);
                    editText.setText(strNumber);
                } catch (Exception e) {
                    editText.setText("error");
                }
            }
        });

        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    strNumber = strToDisplay =(String.valueOf(Math.E)).substring(0, 4);
                    editText.setText(strNumber);
                } catch (Exception e) {
                    editText.setText("error");
                }
            }
        });

        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber= strToDisplay = (String.valueOf(Double.valueOf(strEval) / 100).substring(0, 4));
                    editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }
            }
        });

        btnroot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                try {
                    String strEval = objInterpreter.eval(strNumber).toString();
                    strNumber = strToDisplay =(String.valueOf(Math.sqrt(Double.parseDouble(strEval)))).substring(0, 4);
                    editText.setText(strNumber);
                } catch (Exception evalError) {
                    evalError.printStackTrace();
                    editText.setText("error");
                }
            }
        });

        btnexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNumber += "^";
                strToDisplay += "^";
                blIsExp = true;
                editText.setText(strNumber);
            }
        });

        btnfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    strNumber= strToDisplay = String.valueOf(factorial(Integer.valueOf(strNumber)));
                    editText.setText(strNumber);

                } catch (Exception e) {
                    editText.setText("invalid input");
                }
            }
        });

        btnbx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    strNumber = strToDisplay =String.valueOf(1 / Double.valueOf(strNumber));
                    editText.setText(strNumber);
                } catch (Exception e) {
                    editText.setText("invalid input");
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interpreter objInterpreter = new Interpreter();
                if (blIsExp || strNumber.contains("^")) {
                    try {
                        String strP[] = strNumber.split("\\^");
                        editText.setText(String.valueOf(Math.pow( Double.valueOf(strP[0]),Double.valueOf(strP[1]))));
                        blIsExp = false;
                    } catch (Exception e) {
                        editText.setText("error");
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }

    public static int factorial(int n) {
        int intn = Integer.valueOf(n);
        int fact = 1;
        for (int i = 1; i <= intn; i++) {
            fact *= i;
        }
        return fact;
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

        if (id == R.id.action_basic) {
            Intent intent = new Intent(Advance.this
                    , MainActivity.class);
            intent.putExtra("Number", strNumber);
            intent.putExtra("NumberToDisplay", strToDisplay);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
