package com.example.akhilesh.aaaaa;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class panthers_graph extends Fragment {
    View myView;
    LineChart lineChart;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.panthers_stats, container, false);
        lineChart = (LineChart) myView.findViewById(R.id.panthers_chart);
        ArrayList<Entry> lineEntries;
        lineEntries = new ArrayList<Entry>();
        lineEntries.add(new Entry(0, 17));
        lineEntries.add(new Entry(1, 13));
        lineEntries.add(new Entry(2, 16));
        lineEntries.add(new Entry(3, 21));


        LineDataSet lineDataSet;
        lineDataSet = new LineDataSet(lineEntries, "");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setLineWidth(3);
        // lineDataSet.setColor(getColor("defaultBlue"));
        //lineDataSet.setCircleColor(getColor("defaultOrange"));
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleHoleRadius(3);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighLightColor(Color.RED);
        //  lineDataSet.setValueTextSize(defaultValueTextSize);
        // lineDataSet.setValueTextColor(getColor("primaryDark"));

        LineData lineData = new LineData(lineDataSet);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        lineChart.animateY(1000);
        lineChart.setData(lineData);
        lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
//    mChart = (LineChart) myView.findViewById(R.id.bull_chart);
//    // mChart.setOnChartGestureListener(getActivity());
//    // mChart.setOnChartValueSelectedListener(getActivity());
//        mChart.setDrawGridBackground(false);
//
//    // add data
//    setData();
//
//    // get the legend (only possible after setting data)
//    Legend l = mChart.getLegend();
//
//    // modify the legend ...
//    // l.setPosition(LegendPosition.LEFT_OF_CHART);
//        l.setForm(Legend.LegendForm.LINE);
//
//    // no description text
//    //  mChart.setDescription("Demo Line Chart");
//    // mChart.setNoDataTextDescription("You need to provide data for the chart.");
//
//    // enable touch gestures
//        mChart.setTouchEnabled(true);
//
//    // enable scaling and dragging
//        mChart.setDragEnabled(true);
//        mChart.setScaleEnabled(true);
//    // mChart.setScaleXEnabled(true);
//    // mChart.setScaleYEnabled(true);
//
//    LimitLine upper_limit = new LimitLine(130f, "Upper Limit");
//        upper_limit.setLineWidth(4f);
//        upper_limit.enableDashedLine(10f, 10f, 0f);
//        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        upper_limit.setTextSize(10f);
//
//    LimitLine lower_limit = new LimitLine(-30f, "Lower Limit");
//        lower_limit.setLineWidth(4f);
//        lower_limit.enableDashedLine(10f, 10f, 0f);
//        lower_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        lower_limit.setTextSize(10f);
//
//    YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
//        leftAxis.addLimitLine(upper_limit);
//        leftAxis.addLimitLine(lower_limit);
//        leftAxis.setAxisMaxValue(220f);
//        leftAxis.setAxisMinValue(-50f);
//    //leftAxis.setYOffset(20f);
//        leftAxis.enableGridDashedLine(10f, 10f, 0f);
//        leftAxis.setDrawZeroLine(false);
//
//    // limit lines are drawn behind data (and not on top)
//        leftAxis.setDrawLimitLinesBehindData(true);
//
//        mChart.getAxisRight().setEnabled(false);
//
//    //mChart.getViewPortHandler().setMaximumScaleY(2f);
//    //mChart.getViewPortHandler().setMaximumScaleX(2f);
//
//        mChart.animateX(2500, Easing.EasingOption.EaseInOutQuart);
//
//    //  dont forget to refresh the drawing
//        mChart.invalidate();
//
//
        return myView;
    }

    private ArrayList<String> getXAxisValues()
    {
        ArrayList<String> labels = new ArrayList<String> ();

        labels.add( "2015");
        labels.add( "2016");
        labels.add( "2017");
        labels.add("2018");

        return labels;
    }

    private ArrayList<String> setXAxisValues(){
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("10");
        xVals.add("20");
        xVals.add("30");
        xVals.add("30.5");
        xVals.add("40");

        return xVals;
    }

    private ArrayList<Entry> setYAxisValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(60, 0));
        yVals.add(new Entry(48, 1));
        yVals.add(new Entry(70.5f, 2));
        yVals.add(new Entry(100, 3));
        yVals.add(new Entry(180.9f, 4));

        return yVals;
    }

    private void setData() {
        ArrayList<String> xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;

        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "DataSet 1");

        set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        //   set1.enableDashedLine(10f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets1 = new ArrayList<ILineDataSet>();
        dataSets1.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData((ILineDataSet) xVals,(ILineDataSet)dataSets1);

        // set data
        //mChart.setData(data);

    }

}
