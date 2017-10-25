package kz.kbtu.pizzaapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    GraphView graphView;
    ArrayList<DataPoint> data;
    ArrayList<String> names;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("students", MODE_PRIVATE, null);
        graphView = (GraphView)findViewById(R.id.graph_view);
        button = findViewById(R.id.button_detail);
        data = new ArrayList<>();
        names = new ArrayList<>();
        readFromRaw();
        fillInArrays();
        graphIt();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), DetailActivity.class));
            }
        });

    }


    private void readFromRaw(){
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.pizza));
        String query = "";
        try {
            while (scanner.hasNextLine()){
                query += scanner.nextLine() + "\n";
                if(query.trim().endsWith(";")){
                    Log.d("tag", query);
                    db.execSQL(query);
                    query = "";
                }
            }
        }finally {
            scanner.close();
        }
    }


    private void fillInArrays(){
        String query = "select * from person";
        Cursor c = db.rawQuery(query, null);
        if(c != null){
            c.moveToFirst();
            for(int i = 0; i < c.getCount(); i++){
                names.add(c.getString(0));
                data.add(new DataPoint(i, c.getInt(1)));
                c.moveToNext();
            }
        }
        else{
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }

    }


    private void graphIt(){
        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return names.get((int) value);
                }
                else{
                    return super.formatLabel(value, isValueX);
                }
            }
        });

        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(data.size());
        graphView.getViewport().setScrollable(true);
        DataPoint[] points = new DataPoint[data.size()];
        for(int i = 0; i < data.size(); i++){
            points[i] = data.get(i);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
        graphView.addSeries(series);
    }
}

