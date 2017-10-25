package kz.kbtu.pizzaapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        gridView = findViewById(R.id.grid_view);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        gridView.setAdapter(adapter);
        getContent();
    }


    private void getContent(){
        SQLiteDatabase db = openOrCreateDatabase("students", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("select * from person", null);
        if(c != null){
            c.moveToFirst();
            for(int i = 0; i < c.getCount(); i++){
                data.add(c.getString(c.getColumnIndex("name")));
                data.add(c.getString(c.getColumnIndex("age")));
                data.add(c.getString(c.getColumnIndex("gender")));
                c.moveToNext();
            }
        }
        adapter.notifyDataSetChanged();
    }
}
