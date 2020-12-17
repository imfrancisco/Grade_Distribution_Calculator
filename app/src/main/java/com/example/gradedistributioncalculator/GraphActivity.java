package com.example.gradedistributioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    BarChart barChart;
    double gradeAString;
    Double gradeBString;
    String gradeCString;
    String gradeDString;
    String gradeFString;
    float gradeA,gradeB,gradeC,gradeD,gradeF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        barChart = (BarChart)findViewById(R.id.barChart_mp);

        BarDataSet barDataSet = new BarDataSet(dataValues(),"A's: Blue \t\t\t\t B's: Green: \t\t\t\t C's: Light Pink \t\t\t\t D's: Pink \t\t\t\t F's: Burgundy");
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        BarData barData = new BarData();
        barData.addDataSet(barDataSet);

        barChart.setData(barData);
        Description mDescription = new Description();
        mDescription.setText("Grade Distribution Calculator");
        barChart.setDescription(mDescription);
        barChart.invalidate();

    }

    private ArrayList<BarEntry> dataValues(){
        ArrayList<BarEntry> valuesData = new ArrayList<>();
        valuesData.add(new BarEntry(1,Float.parseFloat(getIntent().getStringExtra("Num of A's Students"))));
        valuesData.add(new BarEntry(2, Float.parseFloat(getIntent().getStringExtra("Num of B's Students"))));
        valuesData.add(new BarEntry(3, Float.parseFloat(getIntent().getStringExtra("Num of C's Students"))));;
        valuesData.add(new BarEntry(4, Float.parseFloat(getIntent().getStringExtra("Num of D's Students"))));
        valuesData.add(new BarEntry(5, Float.parseFloat(getIntent().getStringExtra("Num of F's Students"))));
        return valuesData;
    }
}