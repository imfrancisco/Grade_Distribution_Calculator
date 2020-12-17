package com.example.gradedistributioncalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText studentsNum, aStudents, bStudents, cStudents, dStudents, fStudents;
    private Button buttonCalculate;
    private Double totalStudentsNum=0.0, numAStudents=0.0, numBStudents=0.0, numCStudents=0.0, numDStudents=0.0, numFStudents=0.0;
    private String aPercentage, bPercentage, cPercentage, dPercentage, fPercentage;
    private String totalPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsNum = (EditText)findViewById(R.id.editText_numberOfStudents);
        aStudents = (EditText)findViewById(R.id.editText_numberOf_AsStudents);
        bStudents = (EditText)findViewById(R.id.editText_numberOf_BsStudents);
        cStudents = (EditText)findViewById(R.id.editText_numberOf_CsStudents);
        dStudents = (EditText)findViewById(R.id.editText_numberOf_DsStudents);
        fStudents = (EditText)findViewById(R.id.editText_numberOf_FsStudents);
        buttonCalculate = (Button)findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(studentsNum.getText().toString()) || TextUtils.isEmpty(aStudents.getText().toString()) || TextUtils.isEmpty(bStudents.getText().toString()) || TextUtils.isEmpty(cStudents.getText().toString()) || TextUtils.isEmpty(dStudents.getText().toString()) || TextUtils.isEmpty(fStudents.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setCancelable(true);
                        alertDialogBuilder.setTitle("Percentage of Grade Distribution").setMessage(message());
                        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent graphAct = new Intent(MainActivity.this, GraphActivity.class);
                                graphAct.putExtra("Num of A's Students", aPercentage);
                                graphAct.putExtra("Num of B's Students", bPercentage);
                                graphAct.putExtra("Num of C's Students", cPercentage);
                                graphAct.putExtra("Num of D's Students", dPercentage);
                                graphAct.putExtra("Num of F's Students", fPercentage);
                                startActivity(graphAct);
                            }
                        });
                        alertDialogBuilder.show();
                }
            }
        });
    }


    public void calculatePercentages() {
        getValuesFromEditText();

        aPercentage = String.valueOf((Double) ((numAStudents * 100.00) / totalStudentsNum));
        bPercentage = String.valueOf((Double) ((numBStudents * 100.00) / totalStudentsNum));
        cPercentage = String.valueOf((Double) ((numCStudents * 100.00) / totalStudentsNum));
        dPercentage = String.valueOf((Double) ((numDStudents * 100.00) / totalStudentsNum));
        fPercentage = String.valueOf((Double) ((numFStudents * 100.00) / totalStudentsNum));
    }

    public String message(){
        calculatePercentages();
        String output ="Percentage of Grade Distribution\nA's: " + aPercentage + " %\nB's: " + bPercentage + " %\nC's: " + cPercentage + " %\nD's: " + dPercentage +" %\nF's: " + fPercentage + " %\n";
        return output;
    }

    public void getValuesFromEditText(){
        totalStudentsNum = Double.parseDouble(studentsNum.getText().toString());
        numAStudents = Double.parseDouble(aStudents.getText().toString());
        numBStudents = Double.parseDouble(bStudents.getText().toString());
        numCStudents = Double.parseDouble(cStudents.getText().toString());
        numDStudents = Double.parseDouble(dStudents.getText().toString());
        numFStudents = Double.parseDouble(fStudents.getText().toString());
    }

}